package logic;

import org.junit.Assert;
import org.junit.Test;

public class ReadFilesFromURLTest {

    @Test
    public void getJSONFromURL() {
        ReadFilesFromURL filesFromURL = new ReadFilesFromURL();
        String text = filesFromURL.getJSONFromURL("https://raw.githubusercontent.com/VasiliyLik/Home_work10JSON/main/patientFromConsoleGsonFile.json");
        String result = "[\n" +
                "  {\n" +
                "    \"name\": \"Molly\",\n" +
                "    \"surName\": \"Fiji\",\n" +
                "    \"birthDate\": \"21-12-1993\",\n" +
                "    \"health\": \"unhealthy\"\n" +
                "  }\n" +
                "]\n";
        Assert.assertEquals(result, text);
    }
}