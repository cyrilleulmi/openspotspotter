package ch.ulmc.openspotspotter.spotterapi.eversport;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CourtsService {
    private HttpClient http = HttpClient.newHttpClient();

    @Value("${eversport.baseurl}")
    private String baseUrl;

    @Value("${eversport.slot.path}")
    private String path;

    @Value("${eversport.facility}")
    private String facilityId;

    @Value("${eversport.courts}")
    private String courts;

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
