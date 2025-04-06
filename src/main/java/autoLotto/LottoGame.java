package autoLotto;

public class LottoGame {
    private LottoGenerator lottoGenerator = new LottoGenerator();
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    void play() {
        int budget = inputView.getLottoBudget();
        outputView.printLottoCount(budget);

        LottoResult lottoResult = new LottoResult(budget);

        AutoLotto autoLottos = new AutoLotto(lottoResult.getPurchasedLottoCount());
        System.out.println(autoLottos);

        WinningLotto winningLotto = new WinningLotto(inputView.getLottoWinningNumber(), inputView.getBouns());
        winningLotto.validate();

        processLottoResult(lottoResult, autoLottos, winningLotto);

        outputView.printLottoResult(lottoResult);
    }

    private void processLottoResult(LottoResult lottoResult, AutoLotto autoLotto, WinningLotto winningNumber) {
        autoLotto.getLottos()
                 .forEach(lotto ->
                              lottoResult.addMatchCount(LottoPrize.valueOf(lotto.getMatchedNumberCount(winningNumber)))
                         );
    }

    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        lottoGame.play();
    }
}
