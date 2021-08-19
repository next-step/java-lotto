package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Lottos {

    private List<Lotto> lottoGroup;

    private WinningStatistics winningStatistics;

    public Lottos(List<Lotto> lottoGroup) {
        this.lottoGroup = new ArrayList<>(lottoGroup);
        this.winningStatistics = new WinningStatistics();
    }

    public List<Lotto> getValue() {
        return Collections.unmodifiableList(lottoGroup);
    }

    public void makeWinningLottoResult(WinningLotto winningLotto) {
        for (Lotto lotto : lottoGroup) {
            compareWinningLotto(winningLotto, lotto);
        }
    }

    private void compareWinningLotto(WinningLotto winningLotto, Lotto lotto) {
        int matchCount = countMatchNumber(lotto.getNumbers().getValues(), winningLotto.getNumbers().getValues());
        addPrizeLottoCount(winningLotto, lotto, matchCount);
    }

    private void addPrizeLottoCount(WinningLotto winningLotto, Lotto lotto, int matchCount) {
        Optional<LottoPrizeType> lottoPrizeType = LottoPrizeType.findLottoPrizeByMatchCount(matchCount, lotto.getNumbers().getValues().contains(winningLotto.getBonusNumber()));
        winningStatistics.addCount(lottoPrizeType.orElse(LottoPrizeType.MISS));
    }

    private int countMatchNumber(List<Integer> currentLottoNumber, List<Integer> winningLottoNumber) {
        int matchCount = 0;
        for (int number : winningLottoNumber) {
            matchCount = calcMatchCount(currentLottoNumber, number, matchCount);
        }
        return matchCount;
    }

    private int calcMatchCount(List<Integer> currentLottoNumber, int number, int matchCount) {
        if (currentLottoNumber.contains(number)) {
            return ++matchCount;
        }
        return matchCount;
    }

    public double calcLottoYield(int purchaseAmount) {
        return winningStatistics.calcLottoYield(purchaseAmount);
    }

    public WinningStatistics getWinningStatistics() {
        return winningStatistics;
    }
}
