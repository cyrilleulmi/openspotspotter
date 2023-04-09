package ch.ulmc.openspotspotter.spotterapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.ulmc.openspotspotter.spotterapi.telegram.Services.BotService;
import jakarta.inject.Inject;

@RestController
public class BotController {
    @Inject
    private BotService botService;

    public BotController(BotService botService) {
        this.botService = botService;
    }

    @GetMapping("/test")
    public String testRequest() {
        System.out.println("Request received");
        return "test";
    }
}
