import at.ac.fhcampuswien.jfx.HelloFXData;
import at.ac.fhcampuswien.jfx.Timer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloFXTest {

    @Test
    public void parseTimer_AndCheckMillis() {
        Timer timer = new Timer("5:1:12", null);
        String time= timer.getTimeAsString();
        assertEquals("5:1:12",time);
    }

    @Test
    public void persist() throws Exception
    {
        final String DATAFILE_LOCATION="data.tmp";
        final String MSG_DATA="hi there";
        final String STATUS_DATA="Up";
        final String UPTIME_DATA= "1:20:55";
        final String MSGIMAGE_DATA= "data/einstein.jpg";
        final String STATUSIMAGE_DATA= "data/star.png";

        HelloFXData data = new HelloFXData(DATAFILE_LOCATION);
        data.setMessageData(MSG_DATA);
        data.setStatusData(STATUS_DATA);
        data.setUpTimeData(UPTIME_DATA);
        data.setMessageImageLocation(MSGIMAGE_DATA);
        data.setStatusImageLocation(STATUSIMAGE_DATA);
        data.save();

        HelloFXData data1= HelloFXData.load(DATAFILE_LOCATION);
        assertEquals(MSG_DATA,data1.getMessageData());
        assertEquals(STATUS_DATA,data1.getStatusData());
        assertEquals(UPTIME_DATA,data1.getUpTimeData());
        assertEquals(MSGIMAGE_DATA,data1.getMessageImageLocation());
        assertEquals(STATUSIMAGE_DATA,data1.getStatusImageLocation());
    }


}
