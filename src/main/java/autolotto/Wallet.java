package autolotto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Wallet {
    private final int money;
    private final List<Lotto> lottoList;

    public Wallet(int money) {
        this(money, new ArrayList<>());
    }

    public Wallet(int money, List<Lotto> lottoList) {
        this.money = money;
        this.lottoList = lottoList;
    }

    public void addLotto(Lotto lotto) {
        this.lottoList.add(lotto);
    }

    public int lottoSize() {
        return this.lottoList.size();
    }

    public int totalWinningsOfWinningNumber(List<Integer> winningNumbers) {
        return this.lottoList.stream()
                .map(lotto -> lotto.matchCount(winningNumbers))
                .mapToInt(matchCount -> Winning.winningOf(matchCount).winningMoney())
                .sum();
    }

    public BigDecimal profitRate(List<Integer> winningNumbers) {
        int totalWinnings = totalWinningsOfWinningNumber(winningNumbers);
        return BigDecimal.valueOf(totalWinnings).divide(BigDecimal.valueOf(money), 2, RoundingMode.HALF_UP);
    }

    public int countOfLottoMatchingWith(List<Integer> winningNumber, int matchCount) {
        return (int) this.lottoList.stream()
                .filter(lotto -> lotto.matchCount(winningNumber) == matchCount)
                .count();
    }
}
