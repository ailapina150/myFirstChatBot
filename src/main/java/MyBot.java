import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {
    public static final String USER_NAME = "chat_21122024_bot";
    public static final String TOKEN = "8147125332:AAG1gOR5wjPGGozT2hFVg1Ow1KZEhdFKXCA";


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){
            Long chartId = update.getMessage().getChatId();
            String message = update.getMessage().getText();
            switch (message) {
                case"/start": sendMassage(chartId, "Привет, "+ update.getMessage().getChat().getFirstName()
                        + "! Купи слона.");
                    break;
                default: sendMassage(chartId, "Все говорят: \"" + message + "\" А ты возьми и купи слона.");
            }

        }

    }
     private void sendMassage(Long chartId, String text){
         SendMessage reply = new SendMessage();
         reply.setChatId(chartId.toString());
         reply.setText(text);
         try {
             execute(reply);
         } catch (TelegramApiException e) {
             e.printStackTrace();
         }
     }

    @Override
    public String getBotUsername() {
        return USER_NAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }

}
