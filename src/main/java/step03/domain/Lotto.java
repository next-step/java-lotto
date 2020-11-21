package step03.domain;

import java.util.List;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {
    private final SortedSet<LottoBall> lotto;

    private Lotto (List<LottoBall> lottoBalls) {
        this.lotto = new TreeSet(lottoBalls);
    }

    public static Lotto of(List<LottoBall> lottoBalls) {
        return new Lotto(lottoBalls);
    }

    public static Lotto intOf(List<Integer> lottoBalls) {
        return of(
                lottoBalls.stream()
                        .map(number -> LottoBall.valueOf(number))
                        .collect(Collectors.toList())
        );
    }

    public int matchCount(Lotto targetLotto) {
        int total = 0;
        for(LottoBall lottoBall : lotto)
            if (targetLotto.lotto.contains(lottoBall))
                total += 1;

        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    public boolean isContaining(LottoBall lottoBall) {
        return lotto.contains(lottoBall);
    }
}
