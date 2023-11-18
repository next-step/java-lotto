package step2;

public class LottoGameController {

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    public void game() {
        Money money = new Money(LottoInputView.inputPurchaseMoney());
        Lottos lottos = new Lottos(lottoGenerator.generateLottos(money.determineLottoPurchaseCount()));
        LottoResultView.printLottos(lottos);
        Lotto winningLotto = lottoGenerator.generateWinningLotto(LottoInputView.inputWinningLottoNumber());
        LottoResult lottoResult = new LottoResult(lottos.calculateTotalRank(winningLotto));
        LottoResultView.printLottoResult(lottoResult);
        LottoResultView.printProfitRate(lottoResult, money);
    }
}
