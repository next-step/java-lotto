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
            sum += increaseCountIfMatched(lottoNumber, generatedLotto);
        }

        return sum;
    }

    private static int increaseCountIfMatched(Integer lottoNumber, List<Integer> generatedLotto) {
        if (generatedLotto.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }
}
