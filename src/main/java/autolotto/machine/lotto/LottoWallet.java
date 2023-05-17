package autolotto.machine.lotto;

import autolotto.machine.winning.Winning;
import autolotto.machine.winning.WinningNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoWallet {
    private final List<Lotto> lottoList;

    public LottoWallet() {
        this.lottoList = new ArrayList<>();
    }

    public LottoWallet(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public void addLotto(Lotto lotto) {
        this.lottoList.add(lotto);
    }

    public int lottoSize() {
        return this.lottoList.size();
    }

    public int totalWinningMoneyOf(WinningNumbers winningNumbers) {
        return this.lottoList.stream()
                .map(lotto -> lotto.matchCount(winningNumbers))
                .filter(matchCount -> Winning.minWinningMatchCount() <= matchCount)
                // TODO : Winning.winnigOf(matchCount, true) 는 보너스볼을 받도록 인자 변경시 로직을 변경한다
                .mapToInt(matchCount -> Winning.winningOf(matchCount, true).winningMoney())
                .sum();
    }

    public int countOfLottoMatchingWith(WinningNumbers winningNumber, int matchCount) {
        return (int) this.lottoList.stream()
                .filter(lotto -> lotto.matchCount(winningNumber) == matchCount)
                .count();
    }

    public List<Lotto> allLotteries() {
        return new ArrayList<>(this.lottoList);
    }
}
