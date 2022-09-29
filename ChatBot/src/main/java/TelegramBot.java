import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot {
    private  static final String TOKEN = "5483112369:AAE4Sgdhr4IDme8PEZwXmLHewGNNr8_j4dI";
    private  static final String USER_NAME = "PRM_chat_bot";


    @Override
    public String getBotUsername() {
        return USER_NAME;
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }


    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        Model model = new Model();
        if(message != null && message.hasText()){
            switch (message.getText()){
                case "/help":
                    sendMsg(message , "Вот что у меня есть." + "\n" +
                            "/start" + "\n" +
                            "/help" + "\n" +
                            "/birthdays - Дни рождения" + "\n" +
                            "/game" + " - (Камень , Ножницы , Бумага)" + "\n" +
                            "/weather" + " - Погода" + "\n"
                    );
                    break;
                case "/setting":
                    sendMsg(message , "Что будем настраивать?");
                    break;
                case "/start":
                    sendMsg(message , "Привет я робот секретарь , меня зовут Блэндер " +
                            "для получения списка команд набери или нажми /help");
                    break;
                case "/Who am I":
                    sendMsg(message , "Привет я робот Блэндер " +
                            ", я покажу тебе незримое и научу объять необъятное !");
                    break;

                case "/weather":
                    sendMsg(message , "Прогноз погоды. " + "\n" +
                            "Введите город: к примеру Москва");
                    break;
                case "/birthdays":
                    sendMsg(message , Duty.getDuty());
                    break;
                case "/game":
                    sendMsg(message , "Если хотите играть в игру (Камень , Ножницы , Бумага) " + "\n" +
                            "выберите: " + "\n" +
                            "/stone - Камень" + "\n" +
                            "/scissors - Ножницы" + "\n" +
                            "/paper - Бумага");
                    break;

                case "/stone":
                    sendMsg(message , StoneScissorsPaper.getGame("/stone"));
                    break;
                case "/scissors":
                    sendMsg(message , StoneScissorsPaper.getGame("/scissors"));
                    break;
                case "/paper":
                    sendMsg(message , StoneScissorsPaper.getGame("/paper"));
                    break;

                default:
                    try {
                        sendMsg(message , Weather.getWeather(message.getText() , model));
                    } catch (Exception e){
                        sendMsg(message , "Неизвестная команда. " + "\n" +
                                "Все возможности бота можно узнать по команде /help");
                    }
            }
        }
    }

    public void sendMsg(Message message , String txt) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setReplyToMessageId(message.getMessageId());
        sendMessage.setText(txt);
        SetButton.setButton(sendMessage);
        sendApiMethod(sendMessage);
    }
}