package ch.ulmc.openspotspotter.spotterapi.telegram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class Bot extends TelegramLongPollingBot {
    @Value("${bot.token}")
    private String token;

    @Override
    public void onUpdateReceived(Update update) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onUpdateReceived'");
    }

    @Override
    public String getBotUsername() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBotUsername'");   
    }

    @Override
    public String getBotToken() {
        return token;
    }
}