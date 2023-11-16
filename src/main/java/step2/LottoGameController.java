package step2;

public class LottoGameController {

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void game() {
        int userInput = 2000;
        Lottos lottos = new Lottos(lottoGenerator.generateLottos(userInput));
    }
}
