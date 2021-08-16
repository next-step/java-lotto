package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private List<Lotto> lottoGroup;

    public Lottos(List<Lotto> lottoGroup) {
        this.lottoGroup = new ArrayList<>(lottoGroup);
    }

    public List<Lotto> getValue() {
        return Collections.unmodifiableList(lottoGroup);
    }

    public WinningStatistics findWinningLottoResult(Lotto winningLotto, WinningStatistics winningStatistics) {
        for (Lotto lotto : lottoGroup) {
            int matchCount = countMatchNumber(lotto.getNumbers().getValues(), winningLotto.getNumbers().getValues());
            winningStatistics.addCount(LottoPrizeType.findLottoPrizeByMatchCount(matchCount));
        }
        return winningStatistics;
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
