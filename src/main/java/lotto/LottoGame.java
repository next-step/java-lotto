package lotto;

public class LottoGame {
    public int match(Lotto lotto, Lotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(num -> winningLotto.getNumbers().contains(num))
                .count();
    }

    public Rank getRank(int matchCount) {
        return Rank.of(matchCount);
    }

    public int purchaseLotto(int price) {
        return price / 1000;
    }
}
