package lotto;

import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int amount = LottoInputView.inputAmount();
        LottoStore lottoStore = new LottoStore(amount);
        List<Lotto> lotto = lottoStore.getLotto();
        LottoResultView.printLottoCount(lotto.size());
        LottoResultView.printLotto(lotto);
        String winningLottoNumbers = LottoInputView.inputWinningLottoNumbers();
        lottoStore.registerWinningLotto(winningLottoNumbers);
    }
}
