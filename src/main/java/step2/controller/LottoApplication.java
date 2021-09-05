package step2.controller;

import step2.domain.Lottos;
import step2.domain.Match;
import step2.domain.WinningLotto;
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
        final WinningLotto winningLotto = new WinningLotto(lastWinningNumbers);

        final Match match = winningLotto.match(issueLottos);
        match.calculateProfitRate(inputDto.getAmount());
        outputView.println(match);
    }

    public static Lottos issueLottos(int amount) {
        return new Lottos(amount);
    }
}
