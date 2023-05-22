package lotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.LottoStore.LOTTO_PRICE;

public class Client {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LottoStore lottoStore = new LottoStore();
        int price = inputView.priceView();
        int manualLottoAccount = inputView.manualLottoView();
        List<String> manualLottosString = inputView.manualLottoNumberView(manualLottoAccount);

        List<Lotto> manualLottos = lottoStore.buyManualAndRandomLotto(price, manualLottosString);
        List<Lotto> lottos = lottoStore.buyRandomLotto(price - manualLottoAccount*LOTTO_PRICE);

        List<Lotto> lottosTotal = new ArrayList<>(manualLottos);
        lottosTotal.addAll(lottos);

        resultView.lottoSizeResultView(manualLottos.size(), lottos.size());
        resultView.lottoNumbersView(lottosTotal);

        WinningLotto winningLotto = new WinningLotto(inputView.winnerNumbersView(),inputView.bonusNumbersView());
        LottoResult lottoResult = new LottoResult(lottosTotal, winningLotto);
        resultView.reportView(lottoResult);
    }
}
