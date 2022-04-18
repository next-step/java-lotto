package lotto;

import java.util.ArrayList;
import java.util.List;

public abstract class LottoMachine {

    public static List<Rank> findBoughtLottoRank(List<Integer> winningLotto, List<List<Integer>> lotteries) {
        List<Rank> ranks = new ArrayList<>();

        for (List<Integer> lottery : lotteries) {
            int matchCount = matchLottoNumber(winningLotto, lottery);
            ranks.add(Rank.findRank(matchCount));
        }

        return ranks;
    }

    public static int matchLottoNumber(List<Integer> winLotto, List<Integer> generatedLotto) {
        int sum = 0;

        for (Integer lottoNumber : winLotto) {
            if (isMatchedNumber(lottoNumber, generatedLotto)) {
                sum += 1;
            }
        }

        return sum;
    }

    private static boolean isMatchedNumber(Integer lottoNumber, List<Integer> generatedLotto) {
        return generatedLotto.contains(lottoNumber);
    }
}
