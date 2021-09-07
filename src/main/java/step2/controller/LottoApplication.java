package step2.controller;

import step2.domain.lotto.LottoNumber;
import step2.domain.lotto.LottoNumbers;
import step2.domain.lotto.Lottos;
import step2.domain.lotto.WinningLotto;
import step2.domain.statistics.Amount;
import step2.domain.statistics.Statistics;
import step2.view.InputDto;
import step2.view.InputView;
import step2.view.OutputView;

public class LottoApplication {
        private static final InputView inputView = new InputView();
        private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        final InputDto inputDto = inputView.inputPrice();

        final Amount amount = inputDto.getAmount();
        final Lottos issueLottos = new Lottos(amount);
        outputView.printLottoPurchase(amount, issueLottos);

        final LottoNumbers lastWinningNumbers = inputView.inputLastWinningNumbers();
        final LottoNumber bonusNumber = inputView.inputBonusNumber();
        final WinningLotto winningLotto = new WinningLotto(lastWinningNumbers, bonusNumber);

        final Statistics statistics = winningLotto.match(issueLottos);
        outputView.printResult(statistics);
    }

}
