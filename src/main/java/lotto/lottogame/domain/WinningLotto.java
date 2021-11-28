package lotto.lottogame.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final LottoNumber bonusBall;

    public WinningLotto(List<Integer> winningNumbers, int bonusBall) {
        this.winningNumbers = LottoGenerator.createManualLotto(winningNumbers);
        this.bonusBall = LottoNumber.of(bonusBall);
        if (winningNumbers.contains(bonusBall)) {
            throw new IllegalArgumentException("당첨번호 외에 보너스볼을 입력해주세요");
        }
    }

    public LottoStatistics createLottoStatistics(Lotteries lotteries, OrderPrice orderPrice) {
        Map<Rank, Integer> lottoStatistics = new HashMap<>();
        for (Lotto lotto : lotteries.getLotteries()) {
            Rank rank = Rank.rank(lotto.countOfMatch(winningNumbers), lotto.contains(bonusBall));
            lottoStatistics.put(rank, lottoStatistics.getOrDefault(rank, 0) + 1);
        }
        return new LottoStatistics(lottoStatistics, orderPrice);
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
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
