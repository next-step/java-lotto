package domain;

import java.util.List;

public class Lottos {

    private List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public WinningStatistics findWinningLottoResult(Lotto winningLotto, WinningStatistics winningStatistics) {
        for (Lotto lotto : lottoList) {
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
