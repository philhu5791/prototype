package edu.sdstate.eastweb.prototype.scheduler.tasks;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import edu.sdstate.eastweb.prototype.ConfigReadException;
import edu.sdstate.eastweb.prototype.DataDate;
import edu.sdstate.eastweb.prototype.DirectoryLayout;
import edu.sdstate.eastweb.prototype.ProjectInfo;
import edu.sdstate.eastweb.prototype.database.DatabaseManager;
import edu.sdstate.eastweb.prototype.download.ModisProduct;
import edu.sdstate.eastweb.prototype.download.TrmmProduct;
import edu.sdstate.eastweb.prototype.indices.EnvironmentalIndex;
import edu.sdstate.eastweb.prototype.indices.GdalDummyCalculator;
import edu.sdstate.eastweb.prototype.indices.GdalEtaCalculator;
import edu.sdstate.eastweb.prototype.indices.GdalEviCalculator;
import edu.sdstate.eastweb.prototype.indices.GdalFilterCalculator;
import edu.sdstate.eastweb.prototype.indices.GdalMeanLstCalculator;
import edu.sdstate.eastweb.prototype.indices.GdalNdviCalculator;
import edu.sdstate.eastweb.prototype.indices.GdalNdwi5Calculator;
import edu.sdstate.eastweb.prototype.indices.GdalSaviCalculator;
import edu.sdstate.eastweb.prototype.indices.IndexCalculator;
import edu.sdstate.eastweb.prototype.indices.IndexMetadata;
import edu.sdstate.eastweb.prototype.reprojection.EtoReprojectedMetadata;
import edu.sdstate.eastweb.prototype.reprojection.ModisReprojectedMetadata;
import edu.sdstate.eastweb.prototype.reprojection.TrmmReprojectedMetadata;
import edu.sdstate.eastweb.prototype.scheduler.framework.RunnableTask;

public class GdalCalculateIndexTask implements RunnableTask {
    private final ProjectInfo mProject;
    private final EnvironmentalIndex mIndex;
    private final DataDate mDate;
    private final String mFeature;

    public GdalCalculateIndexTask(ProjectInfo project, EnvironmentalIndex index,
            DataDate date, String feature) {
        mProject = project;
        mIndex = index;
        mDate = date;
        mFeature = feature;
    }

    @Override
    public String getName() {
        return String.format(
                "Calculate index: project=%s index=%s date=%s feature=%s",
                mProject.getName(),
                mIndex.toString(),
                mDate.toCompactString(),
                mFeature
        );
    }

    private File getMetadataFile(String shapeFile) throws ConfigReadException {
        return DirectoryLayout.getIndexMetadata(mProject, mIndex, mDate, shapeFile);
    }

    private IndexMetadata makeMetadata(String shapeFile) throws IOException {
        final List<ModisReprojectedMetadata> modis = new ArrayList<ModisReprojectedMetadata>();
        for (ModisProduct product : getModisProducts()) {
            modis.add(ModisReprojectedMetadata.fromFile(
                    DirectoryLayout.getModisReprojectedMetadata(mProject, product, mDate)
            ));
        }

        final List<TrmmReprojectedMetadata> trmm = new ArrayList<TrmmReprojectedMetadata>();
        //        if (getUsesTrmm()) {
        //            trmm.add(TrmmReprojectedMetadata.fromFile(
        //                    DirectoryLayout.getTrmmReprojectedMetadata(mProject, mDate)
        //                    ));
        //        }

        final List<EtoReprojectedMetadata> eto = new ArrayList<EtoReprojectedMetadata>();
        //        if (getUsesEto()) {
        //            eto.add(EtoReprojectedMetadata.fromFile(
        //                    DirectoryLayout.getEtoReprojectedMetadata(mProject, mDate)
        //                    ));
        //        }

        final long timestamp = new Date().getTime();

        return new IndexMetadata(modis, trmm, eto, shapeFile, timestamp);
    }

    private List<ModisProduct> getModisProducts() {
        switch (mIndex) {
        case LST_DAY:
        case LST_NIGHT:
        case LST_MEAN:
        case ETA:
            return Arrays.asList(ModisProduct.LST);

        case NDVI:
        case EVI:
        case NDWI5:
        case NDWI6:
        case SAVI:
            return Arrays.asList(ModisProduct.NBAR);

        case TRMM:
        case TRMM_RT:
            return Collections.emptyList();

        default:
            throw new IllegalArgumentException();
        }
    }

    private IndexCalculator makeCalculator() throws IOException, SQLException {
        String feature = new File(mFeature).getName().split("\\.")[0];

        //DatabaseManager databaseManager = null;

        //int id = databaseManager.getReprojectedModisId(mProject.getName(), mDate);
        //        File file = databaseManager.downloadProjectedModis(
        //                ModisProduct.NBAR,
        //                databaseManager.getReprojectedModisId(mProject.getName(), mDate)
        //                );
        //
        //        File file = DirectoryLayout.getModisReprojected(mProject, ModisProduct.NBAR, mDate);
        //        int id = databaseManager.getReprojectedModisId(mProject.getName(), mDate);
        //        if (file.exists() && databaseManager.getReprojectedModisUpdatedDate() ) {
        //
        //        }
        //
        //
        //        databaseManager.downloadModis(
        //                ,
        //                ModisProduct.NBAR,
        //                id
        //                );
        //        databaseManager.uploadNdvi(file, mProject.getName(), mDate, updated);

        final File red = DirectoryLayout.getModisClip(mProject, mDate,
                ModisProduct.NBAR, feature, "Nadir_Reflectance_Band1");
        final File nir = DirectoryLayout.getModisClip(mProject, mDate,
                ModisProduct.NBAR, feature, "Nadir_Reflectance_Band2");
        final File day = DirectoryLayout.getModisClip(mProject, mDate,
                ModisProduct.LST, feature, "LST_Day_1km");
        final File night = DirectoryLayout.getModisClip(mProject, mDate,
                ModisProduct.LST, feature, "LST_Night_1km");

        final File output = DirectoryLayout.getIndex(mProject, mIndex, mDate, mFeature);

        FileUtils.forceMkdir(output.getParentFile());

        switch (mIndex) {

        case LST_DAY:
            return new GdalFilterCalculator(day, output, mProject.getMinLst() + 273.15, mProject.getMaxLst() + 273.15);

        case LST_NIGHT:
            return new GdalFilterCalculator(night, output, mProject.getMinLst() + 273.15, mProject.getMaxLst() + 273.15);

        case LST_MEAN:
            return new GdalMeanLstCalculator(day, night, output, mProject.getMinLst() + 273.15, mProject.getMaxLst() + 273.15);

        case NDVI:
            return new GdalNdviCalculator(red, nir, output);

        case EVI:
            final File blue = DirectoryLayout.getModisClip(
                    mProject, mDate, ModisProduct.NBAR, feature, "Nadir_Reflectance_Band3");
            return new GdalEviCalculator(red, nir, blue, output);

        case NDWI5:
            final File swir = DirectoryLayout.getModisClip(
                    mProject, mDate, ModisProduct.NBAR, feature, "Nadir_Reflectance_Band5");
            return new GdalNdwi5Calculator(nir, swir, output);

        case NDWI6:
            final File swir2 = DirectoryLayout.getModisClip(
                    mProject, mDate, ModisProduct.NBAR, feature, "Nadir_Reflectance_Band6");
            return new GdalNdwi5Calculator(nir, swir2, output);

        case SAVI:
            return new GdalSaviCalculator(red, nir, output);

        case ETA:
            final File elevation = new File(DirectoryLayout.getSettingsDirectory(mProject), mProject.getElevation());
            final File eto = DirectoryLayout.getEtoReprojected(mProject, mDate);

            return new GdalEtaCalculator(day, elevation, eto, output, mProject.getMinLst() + 273.15, mProject.getMaxLst() + 273.15);

        case TRMM:
            final File trmm = DirectoryLayout.getTrmmClip(mProject, TrmmProduct.TRMM_3B42, mDate, feature);

            return new GdalDummyCalculator(trmm, output);

        case TRMM_RT:
            final File trmmrt = DirectoryLayout.getTrmmClip(mProject, TrmmProduct.TRMM_3B42RT, mDate, feature);

            return new GdalDummyCalculator(trmmrt, output);

        default:
            throw new IllegalArgumentException(mIndex + " not supported by GDAL index calculation task.");

        }
    }

    @Override
    public void run() throws Exception {
        IndexCalculator calculator = makeCalculator();

        calculator.calculate();

        final File metadataFile = getMetadataFile(mFeature);
        FileUtils.forceMkdir(metadataFile.getParentFile());
        makeMetadata(mFeature).toFile(metadataFile);
    }

    @Override
    public boolean getCanSkip() {
        try {
            return IndexMetadata.fromFile(getMetadataFile(mFeature)).equalsIgnoreTimestamp(makeMetadata(mFeature));
        } catch (Exception e) {
            return false;
        }
    }

}
