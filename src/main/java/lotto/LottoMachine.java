package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public List<Statistic> findBoughtLottoStatistics(List<Integer> winningLotto, List<List<Integer>> lotteries) {
        List<Statistic> statistics = new ArrayList<>();

        for (List<Integer> lottery : lotteries) {
            int matchCount = matchLottoNumber(winningLotto, lottery);
            statistics.add(Statistic.findRank(matchCount));
        }

        return statistics;
    }

    public int matchLottoNumber(List<Integer> winLotto, List<Integer> generatedLotto) {
        int sum = 0;

        for (Integer lottoNumber : winLotto) {
            sum += increaseCountIfMatched(lottoNumber, generatedLotto);
        }

        return sum;
    }

    private int increaseCountIfMatched(Integer lottoNumber, List<Integer> generatedLotto) {
        if (generatedLotto.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }
}
