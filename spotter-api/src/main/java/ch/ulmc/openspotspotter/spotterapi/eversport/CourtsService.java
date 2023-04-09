package ch.ulmc.openspotspotter.spotterapi.eversport;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class CourtsService {
    private HttpClient http = HttpClient.newHttpClient();

    private String baseUrl = "https://www.eversports.ch";
    private String path = "/api/slot";
    private String facilityId = "facilityId=73514";
    private String courts = "courts%5B%5D=62838&courts%5B%5D=62839&courts%5B%5D=62840&courts%5B%5D=62841&courts%5B%5D=62837";

    public String getCourtsFromApiCall(String date) throws IOException, InterruptedException {
        java.net.URI uri = java.net.URI.create(baseUrl + path + "?" + "startDate=" + date + "&" + facilityId + "&" + courts);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .build();

        HttpResponse<String> response = this.http.send(request, BodyHandlers.ofString());
        return response.body().toString();
    }

    public String getCurrentCourtsFromApiCall() throws IOException, InterruptedException {
        return getCourtsFromApiCall(getCurrentDate());
    }

    private String getCurrentDate() {
        Date date = new Date();
        return String.format("%tF", date);
    }
}
