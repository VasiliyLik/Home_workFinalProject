package logic;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
//чтение файла из интернета (например, базы студентов, записанных на Гитхабе)
public class ReadFilesFromURL {
    public String getJSONFromURL(String strUrl) {
        StringBuilder jsonText = new StringBuilder();
        try {
            URL url = new URL(strUrl);
            InputStream is = url.openStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                jsonText.append(line).append("\n");
            }
            is.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonText.toString();
    }
}
