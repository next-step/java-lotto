package lotto.step3.domain;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final LottoNumber bonusBall;

    public WinningLotto(List<Integer> winningNumbers, int bonusBall) {
        checkBonusBall(winningNumbers, bonusBall);
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusBall = new LottoNumber(bonusBall);
    }

    public Map<Integer, Integer> createRepository(Lotteries lotteries) {
        return lotteries.createRepository(winningNumbers);
    }

    public int totalSecondPrizeWinners(Lotteries lotteries) {
        return lotteries.totalSecondPrizeWinners(winningNumbers, bonusBall);
    }

    public double calculateRateOfProfit(Lotteries lotteries, int orderPrice) {
        return lotteries.calculateRateOfProfit(winningNumbers, bonusBall, orderPrice);
    }

    private void checkBonusBall(List<Integer> winningNumbers, int bonusBall) {
        boolean isAllNoneMatch = winningNumbers.stream()
                .noneMatch(number -> number == bonusBall);
        if (isAllNoneMatch) {
            throw new IllegalArgumentException("당첨번호 내에서 보너스볼을 입력해주세요");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningNumbers, that.winningNumbers) && Objects.equals(bonusBall, that.bonusBall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers, bonusBall);
    }

    @Override
    public String toString() {
        return "WinningLotto{" +
                "winningNumbers=" + winningNumbers +
                ", bonusBall=" + bonusBall +
                '}';
    }

}
