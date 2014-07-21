package edu.sdstate.eastweb.prototype.indices;

import java.io.File;

/**
 * 
 * NDWI = (NIR-SWIR2)/(NIR+SWIR2)
 * 
 * @author Isaiah Snell-Feikema
 */
public class GdalNdwi5Calculator extends GdalSimpleIndexCalculator {

    private static final int NIR = 0;
    private static final int SWIR = 1;

    public GdalNdwi5Calculator(File nir, File swir, File output) {
        File[] inputs = new File[2];
        inputs[NIR] = nir;
        inputs[SWIR] = swir;

        setInputFiles(inputs);
        setOutputFile(output);
    }


    @Override
    protected double calculatePixelValue(double[] values) {
        if (values[NIR] == 32767 || values[SWIR] == 32767) {
            return -3.40282346639e+038;
        } else {
            return (values[NIR] - values[SWIR]) / (values[SWIR] + values[NIR]);
        }
    }

}
