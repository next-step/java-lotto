package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Lottos {

    private List<Lotto> lottoGroup;

    public Lottos(List<Lotto> lottoGroup) {
        this.lottoGroup = new ArrayList<>(lottoGroup);
    }

    public List<Lotto> getValue() {
        return Collections.unmodifiableList(lottoGroup);
    }

    public void makeWinningLottoResult(Lotto winningLotto, BonusBall bonusBall) {
        for (Lotto lotto : lottoGroup) {
            compareWinningLotto(winningLotto, lotto, bonusBall);
        }
    }

    private void compareWinningLotto(Lotto winningLotto, Lotto lotto, BonusBall bonusBall) {
        int matchCount = countMatchNumber(lotto.getNumbers().getValues(), winningLotto.getNumbers().getValues());
        addPrizeLottoCount(lotto, matchCount, bonusBall);
    }

    private void addPrizeLottoCount(Lotto lotto, int matchCount, BonusBall bonusBall) {
        if (matchCount == LottoPrizeType.SECOND_PRIZE.getMatchCount()
                && lotto.getNumbers().getValues().contains(bonusBall.getValue())) {
            WinningStatistics.addCount(Optional.of(LottoPrizeType.SECOND_PRIZE));
        }
        WinningStatistics.addCount(LottoPrizeType.findLottoPrizeByMatchCount(matchCount));
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
}
