package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoGame {
    public static final int LOTTO_PRICE = 1000;

    public int match(Lotto lotto, Lotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(num -> winningLotto.getNumbers().contains(num))
                .count();
    }

    public Rank getRank(int matchCount) {
        return Rank.of(matchCount);
    }

    public int purchaseLotto(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException("구매 금액이 로또 한 장 값보다 작을 수 없습니다.");
        }
        return price / LOTTO_PRICE;
    }

    public int getTotalWinnings(List<Rank> winningResults) {
        return winningResults.stream()
                .mapToInt(Rank::getWinningMoney)
                .sum();
    }

    public double getRateOfRevenue(int price, int totalWinnings) {
        return (double) totalWinnings / price;
    }

    public List<Lotto> createLottos(int i) {
        return Stream
                .generate(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))
                .limit(10)
                .collect(toList());

    }
}
