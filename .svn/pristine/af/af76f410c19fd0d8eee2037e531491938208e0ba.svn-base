package edu.sdstate.eastweb.prototype.indices;

import java.io.File;

public class IndexTests {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //testNDWI5();
        //testNDWI6();
        //testEVI();
        //testSAVI();
        //testETa();
        //testNDVI();
        //testEVI();
        testLST();
    }

    public static void testNDWI5() throws Exception {
        Ndwi5Calculator ndwi5 = new Ndwi5Calculator(
                new File("."),
                new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\MCD43B4_Fixed\\band2.tif"),
                new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\MCD43B4_Fixed\\band5.tif"),
                new File("C:\\Users\\isaiah\\Desktop\\shared\\CS\\NGP_shpfile\\WaterMask\\rec_watermask"),
                new File[] {
                    new File("C:\\Users\\isaiah\\Desktop\\shared\\CS\\NGP_shpfile\\NGP_AEA.shp"),
                    new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\Shapefile\\west.shp")
                },
                new File[] {
                    new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\NDWI5\\Result 3\\ndwi5_1"),
                    new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\NDWI5\\Result 3\\ndwi5_2")
                }
        );

        ndwi5.calculate();
    }

    public static void testNDWI6() throws Exception {
        Ndwi6Calculator ndwi6 = new Ndwi6Calculator(
                new File("."),
                new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\MCD43B4_Fixed\\band2.tif"),
                new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\MCD43B4_Fixed\\band6.tif"),
                new File("C:\\Users\\isaiah\\Desktop\\shared\\CS\\NGP_shpfile\\WaterMask\\rec_watermask"),
                new File[] {
                    new File("C:\\Users\\isaiah\\Desktop\\shared\\CS\\NGP_shpfile\\NGP_AEA.shp"),
                    new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\Shapefile\\west.shp")
                },
                new File[] {
                    new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\NDWI6\\Result 3\\ndwi6_1"),
                    new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\NDWI6\\Result 3\\ndwi6_2")
                }
        );

        ndwi6.calculate();
    }

    public static void testSAVI() throws Exception {
        SaviCalculator savi = new SaviCalculator(
                new File("."),
                new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\MCD43B4_Fixed\\band1.tif"),
                new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\MCD43B4_Fixed\\band2.tif"),
                new File("C:\\Users\\isaiah\\Desktop\\shared\\CS\\NGP_shpfile\\WaterMask\\rec_watermask"),
                new File[] {
                    new File("C:\\Users\\isaiah\\Desktop\\shared\\CS\\NGP_shpfile\\NGP_AEA.shp"),
                    new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\Shapefile\\west.shp")
                },
                new File[] {
                    new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\SAVI\\Result 2\\savi1"),
                    new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\SAVI\\Result 2\\savi2")
                }
        );

        savi.calculate();
    }

    public static void testEVI() throws Exception {
        EviCalculator evi = new EviCalculator(
                new File("."),
                new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\MCD43B4_Fixed\\band1.tif"),
                new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\MCD43B4_Fixed\\band2.tif"),
                new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\MCD43B4_Fixed\\band3.tif"),
                new File("C:\\Users\\isaiah\\Desktop\\shared\\CS\\NGP_shpfile\\WaterMask\\rec_watermask"),
                new File[] {
                    new File("C:\\Users\\isaiah\\Desktop\\shared\\CS\\NGP_shpfile\\NGP_AEA.shp"),
                    new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\Shapefile\\west.shp")
                },
                new File[] {
                    new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\EVI\\Result 5\\evi1"),
                    new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\EVI\\Result 5\\evi2")
                }
        );

        evi.calculate();
    }

    public static void testETa() throws Exception {
        EtaCalculator eta = new EtaCalculator(
                new File("."),
                new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\MOD11A2_Fixed\\day185.LST_Day_1km.tif"),
                new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\EastWeb_DEM\\dem_ngp"),
                new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\ETo_Reprojected\\eto"),
                new File[] {
                    new File("E:\\CS\\NGP_shpfile\\NGP_AEA.shp"),
                    new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\Shapefile\\west.shp")
                },
                new File[] {
                    new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\Corrected LST\\Result 3\\clst1"),
                    new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\Corrected LST\\Result 3\\clst2")
                },
                new File[] {
                    new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\ETf\\Result 7\\etf1"),
                    new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\ETf\\Result 7\\etf2")
                },
                new File[] {
                    new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\ETa\\Result 9\\eta1"),
                    new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\ETa\\Result 9\\eta2")
                }
        );

        eta.calculate();
    }

    public static void testNDVI() throws Exception {
        NdviCalculatorArcpyImpl ndvi = new NdviCalculatorArcpyImpl(
                new File("."),
                new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\MCD43B4_Fixed\\band1.tif"),
                new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\MCD43B4_Fixed\\band2.tif"),
                new File("C:\\Users\\isaiah\\Desktop\\shared\\CS\\NGP_shpfile\\WaterMask\\rec_watermask"),
                new File[] {new File("C:\\Users\\isaiah\\Desktop\\shared\\CS\\NGP_shpfile\\NGP_AEA.shp")},
                new File[] {new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\NDVI\\Result 6\\ndvi")}
        );

        ndvi.calculate();
    }

    public static void testLST() throws Exception {
        LstCalculator lst = new LstCalculator(
                new File("."),
                new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\MOD11A2_Fixed\\day185.LST_Day_1km.tif"),
                new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\MOD11A2_Fixed\\day185.LST_Night_1km.tif"),
                new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\watermask\\rec_watermask"),
                new File[] {new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\shapefile\\west.shp")},
                new File[] {new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\LST\\Result 3\\day")},
                new File[] {new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\LST\\Result 3\\mean")},
                new File[] {new File("C:\\Users\\isaiah\\Desktop\\shared\\IndexComputations\\IndiceTesting\\LST\\Result 3\\night")}
        );

        lst.calculate();
    }

}
