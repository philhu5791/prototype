package edu.sdstate.eastweb.prototype.indices;

import java.io.File;

import edu.sdstate.eastweb.prototype.Config;
import edu.sdstate.eastweb.prototype.Python;
import edu.sdstate.eastweb.prototype.util.PythonHelper;

/**
 * TRMM calculator.
 * 
 * @author Isaiah Snell-Feikema
 */
public class TrmmCalculator implements IndexCalculator {
    private File workspace;
    private File trmm;
    private File shapefiles[];
    private File outputs[];

    public TrmmCalculator(File workspace, File trmm, File[] shapefiles, File[] outputs) {
        this.workspace = workspace;
        this.trmm = trmm;
        this.shapefiles = shapefiles;
        this.outputs = outputs;
    }

    @Override
    public void calculate() throws Exception {
        Python.run(
                "python/trmm.py",
                Config.getInstance().getIndexPythonTimeout(),
                workspace.toString(),
                trmm.toString(),
                PythonHelper.packParameters(shapefiles, ';'),
                PythonHelper.packParameters(outputs, ';')
        );
    }
}
