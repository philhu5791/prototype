package edu.sdstate.eastweb.prototype.reprojection;

import java.io.File;

import edu.sdstate.eastweb.prototype.Config;
import edu.sdstate.eastweb.prototype.Projection;
import edu.sdstate.eastweb.prototype.Python;
import edu.sdstate.eastweb.prototype.util.PythonHelper;


/**
 * Composites and reprojects ETo data.
 * 
 * @author Isaiah Snell-Feikema
 */
public class EtoReprojection extends ArcGisReprojection {
    /**
     * Composites and reprojects the specified ETo data.
     * 
     * @param inFiles ETo files to composite and reproject.
     * @param projection the projection to reproject the ETo into.
     * @param outFile the composited and reprojected ETo output file.
     */
    public void reprojectEto(File workspace, File[] inFiles, Projection projection, File outFile)
    throws Exception
    {
        // Convert resampling type to ArcPy name
        String resamplingType = translateResamplingType(projection.getResamplingType());

        // Get output coordinate system
        File projectionFile = createProjectionFile(projection);

        String transform = Config.getInstance().getEToTransform(projection.getDatum());

        // Run Python script
        Python.run(
                "python/eto.py",
                Config.getInstance().getReprojectionPythonTimeout(),
                workspace.toString(),
                PythonHelper.packParameters(inFiles, ';'),
                "./coordinate_systems/NAD 1983.prj",
                projectionFile.toString(),
                resamplingType,
                Integer.toString(projection.getPixelSize()),
                transform,
                outFile.toString()
        );

        // Clean up
        projectionFile.delete();
    }

}
