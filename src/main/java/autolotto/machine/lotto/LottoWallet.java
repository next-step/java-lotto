package autolotto.machine.lotto;

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

    public int countOfLottoMatchingWith(WinningNumbers winningNumber, int matchCount) {
        return (int) this.lottoList.stream()
                .filter(lotto -> lotto.matchCount(winningNumber) == matchCount)
                .count();
    }

    public List<Lotto> allLotteries() {
        return new ArrayList<>(this.lottoList);
    }
}
