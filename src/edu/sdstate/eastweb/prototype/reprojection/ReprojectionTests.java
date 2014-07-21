package edu.sdstate.eastweb.prototype.reprojection;

import java.io.File;

import edu.sdstate.eastweb.prototype.Config;
import edu.sdstate.eastweb.prototype.Projection;
import edu.sdstate.eastweb.prototype.Projection.Datum;
import edu.sdstate.eastweb.prototype.Projection.ProjectionType;
import edu.sdstate.eastweb.prototype.Projection.ResamplingType;

public class ReprojectionTests {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //testETo();
        //testTRMM();
        testModis();
    }

    public static void testModis() throws Exception {
        Projection projection = Config.getInstance().loadProject("Test Project 2").getProjection();

        new ModisReprojection().reprojectModis(
                new File[] {
                        new File("C:\\Users\\isaiah\\Desktop\\eastweb-data\\download\\modis-lst\\2010\\209\\h10v08\\tile.hdf"),
                        new File("C:\\Users\\isaiah\\Desktop\\eastweb-data\\download\\modis-lst\\2010\\209\\h10v09\\tile.hdf")
                },
                new boolean[] {true},
                projection,
                new File("C:\\Users\\isaiah\\Desktop\\output.tif"));
    }

    public static void testETo() throws Exception {
    }

    public static void testTRMM() throws Exception {
        Projection ngp = new Projection(
                ProjectionType.ALBERS_EQUAL_AREA,
                ResamplingType.BILINEAR,
                Datum.NAD83,
                0, //pixel size
                0, 0, // semi axis
                43, 47, // std par
                0, // scaling fact
                -102, // cent mer
                0, 0, // fe and fn
                45 // lat of orig
        );

        // Projection ethiopia = new Projection(
        //         ProjectionType.TRANSVERSE_MERCATOR,
        //         ResamplingType.BILINEAR,
        //         Datum.WGS84,
        //         1000, //pixel size
        //         0, 0, // semi axis
        //         0, 0, // std par
        //         0.9996, // scaling fact
        //         39, // cent mer
        //         500000.0, 10000000.0, // fe and fn
        //         45 // lat of orig
        // );

        TrmmReprojection r = new TrmmReprojection();
        r.reprojectTrmm(
                new File("."),
                new File("Z:\\IndexComputations\\TRMM\\3b42_daily.2011.04.27.6.bin.nc"),
                ngp,
                new File("C:\\Users\\isaiah\\Desktop\\TRMM\\trmm")
        );
    }

}
