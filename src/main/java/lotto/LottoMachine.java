package lotto;

import java.util.ArrayList;
import java.util.List;

public abstract class LottoMachine {

    public static List<Rank> findBoughtLottoRank(List<Integer> winningLotto, List<Lotto> lotteries) {
        List<Rank> ranks = new ArrayList<>();

        for (Lotto lottery : lotteries) {
            int matchCount = findMatchedLottoNumberCount(winningLotto, lottery);
            ranks.add(Rank.findRank(matchCount, false));
        }

        return ranks;
    }

    public static int findMatchedLottoNumberCount(List<Integer> winLotto, Lotto generatedLotto) {
        int sum = 0;

        for (Integer lottoNumber : winLotto) {
            if (isMatchedNumber(lottoNumber, generatedLotto)) {
                sum += 1;
            }
        }

        return sum;
    }

    private static boolean isMatchedNumber(Integer lottoNumber, Lotto generatedLotto) {
        return generatedLotto
                .getLottoNumbers()
                .contains(lottoNumber);
    }

    public static boolean isMatchedBonusNumber(int bonusNumber, Lotto generatedLotto) {
        return generatedLotto.getLottoNumbers()
                .contains(bonusNumber);
    }
}
