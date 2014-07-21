package edu.sdstate.eastweb.prototype.reprojection;

import java.io.File;

import org.apache.commons.io.FileUtils;

import edu.sdstate.eastweb.prototype.*;

/**
 * Converts TRMM data from NetCDF and reprojects it.
 * 
 * @author Isaiah Snell-Feikema
 */
public class TrmmReprojection extends ArcGisReprojection {

    /**
     * Converts TRMM data from NetCDF and reprojects it to the specified
     * projection.
     * 
     * @param workspace workspace to use
     * @param inFile TRMM NetCDF file in WGS 1984 projection
     * @param projection the projection to reproject the TRMM to
     * @param outFile the converted and reprojected TRMM file
     * @throws Exception if anything goes wrong
     */
    public void reprojectTrmm(File workspace, File inFile, Projection projection, File outFile)
    throws Exception
    {
        // Convert resampling type to ArcPy name
        String resamplingType = translateResamplingType(projection.getResamplingType());

        // Create projection file for output coordinate system
        File projectionFile = createProjectionFile(projection);

        String transform = Config.getInstance().getTrmmTransform(projection.getDatum());

        // Run Python script
        Python.run(
                "python/reproject_trmm.py",
                Config.getInstance().getReprojectionPythonTimeout(),
                workspace.toString(),
                inFile.toString(),
                new File("coordinate_systems/WGS 1984.prj").getAbsolutePath(),
                projectionFile.toString(),
                resamplingType,
                "#", // TRMM is not resampled to different cell size
                transform,
                outFile.toString()
        );

        // Clean up
        projectionFile.delete();
    }

}

