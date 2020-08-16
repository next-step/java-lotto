package lotto.domain;

import common.StringResources;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final int money;
    private final List<LottoNumber> lottoNumberList;
    private final LottoResultNumber lottoResultNumber;

    private final Map<Integer, Integer> winCount;

    private final double earningsRate;

    public LottoResult(int money, List<LottoNumber> lottoNumberList, LottoResultNumber lottoResultNumber) {

        this.money = money;
        this.winCount = setWinCount();

        this.lottoNumberList = lottoNumberList;
        this.lottoResultNumber = lottoResultNumber;

        matchNumbersCheck();
        this.earningsRate = calculateEarningsRate();
    }

    private Map<Integer, Integer> setWinCount() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);
        Collections.unmodifiableMap(map);
        return map;
    }

    private void matchNumbersCheck() {

        for (LottoNumber lottoNumber : lottoNumberList) {
            long count = lottoNumber.getNumbers().stream()
                    .flatMap(i -> lottoResultNumber.getNumbers().stream()
                            .map(j -> new int[] { i, j } ))
                    .filter(array -> array[0] == array[1])
                    .count();

            winCount.computeIfPresent((int) count, (Integer key, Integer value) -> ++value);
        }
    }

    private double calculateEarningsRate() {

        int earningMoney = 0;

        for (int i = 3; i <= 6; i++) {
            earningMoney += winCount.get(i) * WinningAmount.of(i).getMoney();
        }

        return (double)earningMoney / (double)money;
    }

    public int getWinningCount(int matchCount) {

        if (matchCount < 0 || matchCount > 6) {
            throw new IllegalArgumentException(StringResources.ERR_WRONG_RANGE_RESULT_NUMBER);
        }

        return winCount.get(matchCount);
    }

    public double getEarningsRate() {
        return earningsRate;
    }
}
