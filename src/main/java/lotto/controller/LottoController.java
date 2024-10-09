package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public LottoController() {
    }

    public void run() {
        LottoGenerator lottoGenerator = new LottoGenerator(InputView.getPurchasePrice());
        ResultView.printPurchaseLottoCount(lottoGenerator.getLottos());
        WinningLotto winningLotto = generateWinningLotto();
    }

    private WinningLotto generateWinningLotto() {
        final List<Integer> winningNumbers = InputView.getWinningNumbers();
        List<LottoNumber> winningLottos = winningNumbers.stream()
                .map(LottoNumber::generateByValue)
                .collect(Collectors.toList());
        return new WinningLotto(winningLottos);
    }
}
