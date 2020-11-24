package step3.lotto.conatroller;


import step2.lotto.automatic.domain.LottoMatch;
import step2.lotto.automatic.view.InputLottoView;
import step2.lotto.automatic.view.OuterLottoView;

public class LottoController {

    private static LottoMatch lottoMatch;

    public void gameStart() {
        int purchaseAmount = InputLottoView.inputValue();
        lottoMatch = new LottoMatch(purchaseAmount);
        lottoMatch.buyLotto();

        OuterLottoView.printBuyLotto(lottoMatch.getLottoPurchaseCount());
        OuterLottoView.printAutoLottoNumbers(lottoMatch.getBuyLottoHashSet(), lottoMatch.getLottoPurchaseCount());

        String inputLottoWinnerNumber = InputLottoView.inputWinningLottoNumbers();
        lottoMatch.getLottoResult(inputLottoWinnerNumber);

        OuterLottoView.printLottoResult();
        OuterLottoView.printLottoProfitAmount(lottoMatch.getlottoProfitAmount());
    }

}
