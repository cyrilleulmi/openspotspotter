package ch.ulmc.openspotspotter.spotterapi.eversport;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import jakarta.inject.Inject;

@SpringBootTest(classes = CourtsService.class)
public class CourtsServiceTest {
    @Inject
    private CourtsService testee;

    @Test
    void testGetCourtsFromApiCall() throws IOException, InterruptedException {
        String response = testee.getCurrentCourtsFromApiCall();
        assertThat(response).isNotNull();
    }
}
