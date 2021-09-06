package step2.controller;

import step2.domain.lotto.Lottos;
import step2.domain.statistics.WinningStatistics;
import step2.domain.lotto.WinningLotto;
import step2.view.InputDto;
import step2.view.InputView;
import step2.view.OutputView;

import java.util.List;

public class LottoApplication {
        private static final InputView inputView = new InputView();
        private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        final InputDto inputDto = inputView.inputPrice();

        final int amount = inputDto.getAmount();
        final Lottos issueLottos = issueLottos(amount);
        outputView.printLottoPurchase(amount, issueLottos);

        final List<Integer> lastWinningNumbers = inputView.inputLastWinningNumbers();
        final int bonusNumber = inputView.inputBonusNumber();
        final WinningLotto winningLotto = new WinningLotto(lastWinningNumbers, bonusNumber);

        final WinningStatistics winningStatistics = winningLotto.match(issueLottos);
        outputView.println(winningStatistics);
    }

    public static Lottos issueLottos(int amount) {
        return new Lottos(amount);
    }
}
