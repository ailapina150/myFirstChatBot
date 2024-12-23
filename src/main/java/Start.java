import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Start {
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        DefaultBotOptions botOptions = new DefaultBotOptions();
        botOptions.setProxyHost("74.56.228.180");
        botOptions.setProxyPort(4145);
        botOptions.setProxyType(DefaultBotOptions.ProxyType.SOCKS4);

        MyBot myBot = new MyBot();
        try {
            telegramBotsApi.registerBot(myBot);
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }
}
