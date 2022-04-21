package lotto;

import java.util.ArrayList;
import java.util.List;

public abstract class LottoMachine {

    public static List<Rank> findBoughtLottoRank(List<Integer> winningLotto, List<Lotto> lotteries, int bonusNumber) {
        List<Rank> ranks = new ArrayList<>();

        for (Lotto lottery : lotteries) {
            int matchCount = findMatchedLottoNumberCount(winningLotto, lottery);
            ranks.add(Rank.findRank(matchCount, lottery.isBonusNumberMatched(matchCount, bonusNumber)));
        }

        return ranks;
    }

    static int findMatchedLottoNumberCount(List<Integer> winLotto, Lotto generatedLotto) {
        int sum = 0;

        for (Integer lottoNumber : winLotto) {
            if (generatedLotto.isMatchedNumber(lottoNumber)) {
                sum += 1;
            }
        }

        return sum;
    }

}
