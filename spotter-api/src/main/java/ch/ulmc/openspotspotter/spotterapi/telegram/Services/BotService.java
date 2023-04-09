package ch.ulmc.openspotspotter.spotterapi.telegram.Services;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import ch.ulmc.openspotspotter.spotterapi.telegram.Bot;
import jakarta.inject.Inject;

@Service
public class BotService {
    @Inject
    private Bot bot;

    public BotService(Bot bot) throws TelegramApiException {
        this.bot = bot;
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(this.bot);
    }
}
