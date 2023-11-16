package step2;

public class LottoGameController {

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void game() {
        int userInput = 2000;
        String userWinningInput = "1, 2, 3, 4, 5, 6";
        Lottos lottos = new Lottos(lottoGenerator.generateLottos(userInput));
        Lotto winningLotto = lottoGenerator.generateWinningLotto(userWinningInput);
    }
}
