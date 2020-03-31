package lotto;

public class LottoGame {
    public static int match(Lotto lotto, Lotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(num -> winningLotto.getNumbers().contains(num))
                .count();
    }

    public static Rank getRank(int matchCount) {
        return Rank.of(matchCount);
    }
}
