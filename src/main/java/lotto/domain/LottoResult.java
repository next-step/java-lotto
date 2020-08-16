package lotto.domain;

import common.StringResources;

import java.util.List;

public class LottoResult {

    private final int money;
    private final List<LottoNumber> lottoNumberList;
    private final LottoResultNumber lottoResultNumber;
    private final WinningCountMap winningCountMap;

    private final double earningsRate;

    public LottoResult(int money, List<LottoNumber> lottoNumberList, LottoResultNumber lottoResultNumber) {

        this.money = money;
        this.winningCountMap = new WinningCountMap();
        this.lottoNumberList = lottoNumberList;
        this.lottoResultNumber = lottoResultNumber;

        matchNumbersCheck();
        this.earningsRate = calculateEarningsRate();
    }

    private void matchNumbersCheck() {

        for (LottoNumber lottoNumber : lottoNumberList) {
            long count = lottoNumber.getNumbers().stream()
                    .flatMap(i -> lottoResultNumber.getNumbers().stream()
                            .map(j -> new int[] { i, j } ))
                    .filter(array -> array[0] == array[1])
                    .count();

            winningCountMap.addCount((int) count);
        }
    }

    private double calculateEarningsRate() {

        int earningMoney = 0;

        for (int i = 3; i <= 6; i++) {
            earningMoney += winningCountMap.get(i) * WinningAmount.of(i).getMoney();
        }

        return (double)earningMoney / (double)money;
    }

    public int getWinningCount(int matchCount) {
        return winningCountMap.get(matchCount);
    }

    public double getEarningsRate() {
        return earningsRate;
    }
}
