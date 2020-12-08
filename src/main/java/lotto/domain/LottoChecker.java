package lotto.domain;

import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoChecker {

    private final Lotto winningLotto;

    private final LottoNumber bonusBall;

    public LottoChecker(Lotto winningLotto, LottoNumber bonusBall) {
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public WinningCount countWinningLottoes(Lottoes lottoes) {
        return new WinningCount(lottoes.getLottoes().stream()
                .map(lotto -> Rank.valueOf(winningLotto.countContainNumbers(lotto),
                        lotto.contains(bonusBall)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }
}
