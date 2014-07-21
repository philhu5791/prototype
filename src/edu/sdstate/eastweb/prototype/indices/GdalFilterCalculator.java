package edu.sdstate.eastweb.prototype.indices;

import java.io.File;

public class GdalFilterCalculator extends GdalSimpleIndexCalculator {

    final static int INPUT = 0;

    final double mMin;
    final double mMax;

    public static void main(String[] args) throws Exception {
        new GdalFilterCalculator(new File(args[0]), new File(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3])).calculate();
    }

    public GdalFilterCalculator(File input, File output, double min, double max) {
        File[] inputFiles = new File[1];
        inputFiles[INPUT] = input;

        setInputFiles(inputFiles);
        setOutputFile(output);

        mMin = min;
        mMax = max;
    }

    @Override
    protected double calculatePixelValue(double[] values) {
        if (values[INPUT] < mMin || values[INPUT] > mMax) {
            return -3.4028234663852886E38;
        } else {
            return values[INPUT];
        }
    }

}
