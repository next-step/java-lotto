import config.LottoAppConfig;
import service.LottoGameHandler;

public class LottoApplication {

    public static void main(String[] args) {
        LottoAppConfig appConfig = new LottoAppConfig();
        LottoGameHandler gameHandler = new LottoGameHandler(appConfig);
        gameHandler.runGame();
    }
}
