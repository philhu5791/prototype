package edu.sdstate.eastweb.prototype.indices;

import java.io.File;

/**
 * 
 * NDWI = (NIR-SWIR)/(NIR+SWIR)
 * 
 * @author Isaiah Snell-Feikema
 */
public class GdalNdwi6Calculator extends GdalSimpleIndexCalculator {

    private static final int NIR = 0;
    private static final int SWIR2 = 1;

    public GdalNdwi6Calculator(File nir, File swir2, File output) {
        File[] inputs = new File[2];
        inputs[NIR] = nir;
        inputs[SWIR2] = swir2;

        setInputFiles(inputs);
        setOutputFile(output);
    }


    @Override
    protected double calculatePixelValue(double[] values) {
        if (values[NIR] == 32767 || values[SWIR2] == 32767) {
            return -3.40282346639e+038;
        } else {
            return (values[NIR] - values[SWIR2]) / (values[SWIR2] + values[NIR]);
        }
    }

}
