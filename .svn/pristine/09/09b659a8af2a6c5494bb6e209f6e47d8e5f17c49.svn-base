package edu.sdstate.eastweb.prototype.indices;

import java.io.File;

import edu.sdstate.eastweb.prototype.Config;
import edu.sdstate.eastweb.prototype.Python;
import edu.sdstate.eastweb.prototype.util.PythonHelper;

/**
 * ETa calculator.
 * 
 * @author Isaiah Snell-Feikema
 */
public class EtaCalculator implements IndexCalculator {
    private File workspace;
    private File daytimeLST;
    private File elevation;
    private File eto;
    private File[] shapefiles;
    private File[] correctedLSTOutputs;
    private File[] etfOutputs;
    private File[] etaOutputs;

    public EtaCalculator(File workspace, File daytimeLst, File elevation, File eto,
            File[] shapefiles, File[] correctedLstOutputs, File[] etfOutputs, File[] etaOutputs) {
        this.workspace = workspace;
        daytimeLST = daytimeLst;
        this.elevation = elevation;
        this.eto = eto;
        this.shapefiles = shapefiles;
        correctedLSTOutputs = correctedLstOutputs;
        this.etfOutputs = etfOutputs;
        this.etaOutputs = etaOutputs;
    }

    @Override
    public void calculate() throws Exception {
        Python.run(
                "python/eta.py",
                Config.getInstance().getIndexPythonTimeout(),
                workspace.toString(),
                daytimeLST.toString(),
                elevation.toString(),
                eto.toString(),
                PythonHelper.packParameters(shapefiles, ';'),
                PythonHelper.packParameters(correctedLSTOutputs, ';'),
                PythonHelper.packParameters(etfOutputs, ';'),
                PythonHelper.packParameters(etaOutputs, ';')
        );
    }
}
