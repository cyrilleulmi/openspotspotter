package ch.ulmc.openspotspotter.spotterapi.telegram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class Bot extends TelegramLongPollingBot {
    @Value("${bot.token}")
    private String token;

    @Value("${bot.name}")
    private String name;

    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = SendMessage.builder().chatId(update.getMessage().getChatId().toString())
                .text("Hello " + update.getMessage().getFrom().getFirstName()).build();
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        };
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