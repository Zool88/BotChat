import java.util.ArrayList;
import java.util.Random;

public class StoneScissorsPaper {



    public static String getGame(String str){

        if (str.equals("/stone")){
            str = "stone";
        }
        if (str.equals("/scissors")){
            str = "scissors";
        }
        if (str.equals("/paper")){
            str = "paper";
        }


        ArrayList list = new ArrayList<>();
        list.add("stone");
        list.add("scissors");
        list.add("paper");

        Random r = new Random();
        String random = (String) list.get(r.nextInt(list.size()));
        String res = null;

        if (random.equals("stone") && str.equals("stone") ||
                random.equals("scissors") && str.equals("scissors") ||
                random.equals("paper") && str.equals("paper")
        ){
            res =   "--------------------------------------" +"\n" +
                    "Вы " + str + " | " + "Бот " + random + "\n" +
                    "--------------------------------------" +"\n" +
                    "Ничья " + "\uD83E\uDD1D" + "\n" +
                    "выберите:" + "\n" +
                    "/stone" + "\n" +
                    "/scissors" + "\n" +
                    "/paper" + "\n" +
                    "если хотите продолжить или /help для другого запроса "
            ;
        }
        if (random.equals("scissors") && str.equals("stone") ||
                random.equals("paper") && str.equals("scissors") ||
                random.equals("stone") && str.equals("paper")
        ){
            res =   "--------------------------------------" +"\n" +
                    "Вы " + str + " | " + "Бот " + random + "\n" +
                    "--------------------------------------" +"\n" +
                    "Вы выйграли " + "\uD83D\uDC4D"+ "\n" +
                    "выберите:" + "\n" +
                    "/stone" + "\n" +
                    "/scissors" + "\n" +
                    "/paper" + "\n" +
                    "если хотите продолжить или /help для другого запроса "
            ;
        }
        if (random.equals("paper") && str.equals("stone") ||
                random.equals("stone") && str.equals("scissors") ||
                random.equals("scissors") && str.equals("paper")
        ){
            res =   "--------------------------------------" +"\n" +
                    "Вы " + str + " | " + "Бот " + random + "\n" +
                    "--------------------------------------" +"\n" +
                    "Вы проиграли " + "\uD83D\uDC4E"+ "\n" +
                    "выберите:" + "\n" +
                    "/stone" + "\n" +
                    "/scissors" + "\n" +
                    "/paper" + "\n" +
                    "если хотите продолжить или /help для другого запроса "
            ;
        }
        return res;
    }
}
