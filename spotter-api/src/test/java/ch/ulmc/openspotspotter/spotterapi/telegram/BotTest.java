package ch.ulmc.openspotspotter.spotterapi.telegram;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Bot.class)
public class BotTest {
    @Autowired
    Bot testee;

    @Test
    void testGetBotToken() {
        System.out.println(System.getProperty("workspaceFolder"));
        String botToken = testee.getBotToken();
        assertThat(botToken).isNotNull();
    }

    @Test
    void testTokenSetCorrectly() {
        String botToken = testee.getBotToken();
        assertThat(botToken).isEqualTo("testtoken");
    }
}
