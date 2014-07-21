package edu.sdstate.eastweb.prototype;

import edu.sdstate.eastweb.prototype.Projection.Datum;
import edu.sdstate.eastweb.prototype.Projection.ProjectionType;
import edu.sdstate.eastweb.prototype.Projection.ResamplingType;

public class ConfigTests {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        testProjectSave();
        testProjectLoad();
        testNormalize();

        Config config = Config.getInstance();
        System.out.println(config.getMRTDir());
        System.out.println(config.getDatabaseHost());
        System.out.println(config.getDatabaseUsername());
        System.out.println(config.getDatabasePassword());
        System.out.println(config.getEToTransform(Datum.NAD27));
        System.out.println(config.getEToTransform(Datum.NAD83));
        System.out.println(config.getEToTransform(Datum.WGS66));
        System.out.println(config.getEToTransform(Datum.WGS72));
        System.out.println(config.getEToTransform(Datum.WGS84));
        System.out.println(config.getTrmmTransform(Datum.NAD27));
        System.out.println(config.getTrmmTransform(Datum.NAD83));
        System.out.println(config.getTrmmTransform(Datum.WGS66));
        System.out.println(config.getTrmmTransform(Datum.WGS72));
        System.out.println(config.getTrmmTransform(Datum.WGS84));
        System.out.println(config.getHostAddress());
        System.out.println(config.getControlPort());
        System.out.println(config.getTransferPort());
    }

    public static void testProjectSave() throws Exception {
        Projection projection = new Projection(
                ProjectionType.TRANSVERSE_MERCATOR,
                ResamplingType.NEAREST_NEIGHBOR,
                Datum.NAD83,
                1000,
                1.0, 2.0, 43.0,
                47.0, 3.0, -102.0,
                45.0, 4.0, 5.0
        );

        ProjectInfo projectInfo = new ProjectInfo(
                "Test Project",
                new DataDate(5,3,2002),
                "watermask",
                "elevation.dem",
                projection,
                new ModisTile[] {
                    new ModisTile(3,2),
                    new ModisTile(3,3),
                    new ModisTile(3,4)
                },
                new ZonalSummary[] {
                    new ZonalSummary("Counties","shapefile.shp","counties"),
                    new ZonalSummary("FIPs","shapefile.shp","fips")
                },
                false
        );

        System.out.println(projectInfo.toString());

        Config.getInstance().saveProject(projectInfo);
    }


    public static void testProjectLoad() throws Exception {
        Config config = Config.getInstance();

        String[] projectNames = config.getProjectNames();
        for (String name : projectNames) {
            System.out.println(name);
        }
        ProjectInfo projectInfo = config.loadProject(projectNames[0]);
        System.out.println(projectInfo.toString());
    }

    public static void testNormalize() throws Exception {
        Config config = Config.getInstance();
        System.out.println(config.normalizeName("B#kjjyhjeHE*^&@@hZerrg.xmhgh.glgk"));
        System.out.println(config.getProjectFilename("Test Project"));
    }

}
