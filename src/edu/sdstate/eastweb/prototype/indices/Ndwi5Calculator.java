package edu.sdstate.eastweb.prototype.indices;

import java.io.File;

import edu.sdstate.eastweb.prototype.Config;
import edu.sdstate.eastweb.prototype.Python;
import edu.sdstate.eastweb.prototype.util.PythonHelper;

/**
 * NWDI5 calculator.
 * 
 * @author Isaiah Snell-Feikema
 */
public class Ndwi5Calculator implements IndexCalculator {
    private File workspace;
    private File nir;
    private File swir;
    private File watermask;
    private File[] shapefiles;
    private File[] outputs;

    public Ndwi5Calculator(File workspace, File nir, File swir, File watermask, File[] shapefiles,
            File[] outputs) {
        this.workspace = workspace;
        this.nir = nir;
        this.swir = swir;
        this.watermask = watermask;
        this.shapefiles = shapefiles;
        this.outputs = outputs;
    }

    @Override
    public void calculate() throws Exception {
        Python.run(
                "python/ndwi.py",
                Config.getInstance().getIndexPythonTimeout(),
                workspace.toString(),
                nir.toString(),
                swir.toString(),
                watermask.toString(),
                PythonHelper.packParameters(shapefiles, ';'),
                PythonHelper.packParameters(outputs, ';')
        );
    }

}
