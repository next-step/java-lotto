package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoOutlet {
    private static final int LOTTO_PRICE = 1000;

    public static int lottoCount(int money) {
        return money / LOTTO_PRICE;
    }

    public static Lotto generateLotto() {
        return new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    public static List<Lotto> generateLottos(int count) {
        return Stream.generate(LottoOutlet::generateLotto)
                .limit(count)
                .collect(Collectors.toList());
    }

    public static int getWinning(int matchCount) {
        return Winnings.getWinningsAmount(matchCount);
    }

    public static int getWinnings(List<Integer> matchCounts) {
        return matchCounts.stream()
                .mapToInt(Winnings::getWinningsAmount)
                .sum();
    }

    public static int getWinnings(List<Lotto> Lottos, List<Integer> winningNumbers) {
        return Lottos.stream()
                .mapToInt(lotto -> lotto.matchNumbers(winningNumbers))
                .boxed()
                .mapToInt(Winnings::getWinningsAmount)
                .sum();
    }
}
