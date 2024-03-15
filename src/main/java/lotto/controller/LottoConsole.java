package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.Ball;
import lotto.domain.JudgeResult;
import lotto.domain.Lotto;
import lotto.domain.LottoStore;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoConsole {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoConsole(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        int moneyAmount = inputView.inputMoneyAmount();

        Money money = new Money(moneyAmount);
        List<Lotto> _lottos = LottoStore.sellAsMuchAsPossible(money);
        Lottos lottos = new Lottos(_lottos);

        outputView.printPurchasedLottos(lottos);

        List<Integer> lottoNumbers = inputView.inputLottoNumbers();

        Set<Ball> balls = lottoNumbers.stream()
            .map(Ball::new)
            .collect(Collectors.toSet());
        Lotto winningLotto = new Lotto(balls);

        JudgeResult judgeResult = lottos.judge(winningLotto);
        outputView.printJudgeResult(moneyAmount - money.amount(), judgeResult);
    }
}
