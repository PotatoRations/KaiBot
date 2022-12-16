import Listeners.EggReactListener;

public class Main {
    public static void main(String[] args){
        String token = Consts.token;
        KaiBot kaiBot = new KaiBot(token);
        kaiBot.addListener(new EggReactListener(Consts.kaiID));
    }
}
