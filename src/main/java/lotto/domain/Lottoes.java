package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class Lottoes {

    private final List<Lotto> lottoes;

    public Lottoes(final int count) {
        this.lottoes = purchaseLottoes(count);
    }

    public Lottoes(final List<Lotto> lottoes) {
        this.lottoes = Collections.unmodifiableList(lottoes);
    }

    public List<Lotto> getLottoes() {
        return lottoes;
    }

    public WinningCount countWinLotto(Lotto winningLotto, LottoNumber bonusBall) {
        return new WinningCount(lottoes.stream()
                .map(lotto -> Rank.valueOf(winningLotto.countContainNumbers(lotto),
                        lotto.contains(bonusBall)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }

    private List<Lotto> purchaseLottoes(final int count) {
        final List<Lotto> newLottoes = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            newLottoes.add(new Lotto());
        }

        return Collections.unmodifiableList(newLottoes);
    }
}
