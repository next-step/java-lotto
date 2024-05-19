package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoStore;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMain {

    public static void main(String[] args) {
        int amount = InputView.inputAmount();

        LottoStore lottoStore = new LottoStore();
        Lotto lotto = lottoStore.buyAutoLotto(amount);

        ResultView.printBuyLotto(lotto);

        List<Integer> lastWinningNumbers = Arrays.stream(InputView.inputWinningLotto().split(","))
                                                    .map(Integer::parseInt)
                                                    .collect(Collectors.toList());

        WinningLotto winningLotto = new WinningLotto(lastWinningNumbers);
        
        LottoResult lottoResult = new LottoResult(lotto, winningLotto);

        ResultView.printWinningResult(lottoResult);

    }
}
