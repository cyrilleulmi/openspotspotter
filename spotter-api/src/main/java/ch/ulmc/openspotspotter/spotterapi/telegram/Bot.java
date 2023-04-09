package ch.ulmc.openspotspotter.spotterapi.telegram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class Bot extends TelegramLongPollingBot {
    @Value("${bot.token}")
    private String token;

    @Value("${bot.name}")
    private String name;

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update);
    }

    @Override
    public String getBotUsername() {
        return name;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}