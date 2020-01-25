import com.jayway.jsonpath.JsonPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.LocalDate;


public class ServiceCLS {

    public String getResponse(String myURL){
        HttpURLConnection c = null;
        int requestTimeout = 20000;
        String tmpResp = "";
        try {
            URL u = new URL(myURL);
            c = (HttpURLConnection) u.openConnection();
            c.setRequestMethod("GET");
            c.setRequestProperty("Content-Type", "application/json");
            c.setRequestProperty("Content-length", "0");
            c.setUseCaches(false);
            c.setAllowUserInteraction(false);
            c.setConnectTimeout(requestTimeout);
            c.setReadTimeout(requestTimeout);
            c.connect();
            int status = c.getResponseCode();

            switch (status) {
                case 200:
                case 201:
                    BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
                    StringBuilder sb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line+"\n");
                    }
                    br.close();
                    tmpResp = sb.toString();
            }

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tmpResp;
    }


    public String dateString(LocalDate date){
        int year = date.getYear();
        int curentMonth = date.getMonthValue();
        int dayOfMonth = date.getDayOfMonth();
        String day = "";
        String month = "";
        if (dayOfMonth<10){
            day = "0" + dayOfMonth;
        } else day += dayOfMonth;
        if (curentMonth<10){
            month = "0" + curentMonth;
        } else month += curentMonth;
        String currentDate = day + "." + month + "." + year;
        return currentDate;
    }

    public ExRateBean extractBeanFromJSON(String input){
        String data = JsonPath.read(input, "$.pageInfo.pageName");
        float purchaserate = JsonPath.read(input, "$.pageInfo.pagePic");
        float salerate = JsonPath.read(input, "$.pagePosts[0].post_id");

        return new ExRateBean(data, purchaserate, salerate);
    }

}
