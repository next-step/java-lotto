package lotto.domain;

import java.util.List;

public class LottoResult {

    private final int money;
    private final List<LottoNumber> lottoNumberList;
    private final LottoResultNumber lottoResultNumber;
    private final WinningCountMap winningCountMap;

    public LottoResult(int money, List<LottoNumber> lottoNumberList, LottoResultNumber lottoResultNumber) {

        this.money = money;
        this.winningCountMap = new WinningCountMap();
        this.lottoNumberList = lottoNumberList;
        this.lottoResultNumber = lottoResultNumber;

        matchNumbersCheck();
    }

    private void matchNumbersCheck() {

        for (LottoNumber lottoNumber : lottoNumberList) {
            long count = lottoNumber.getNumbers().stream()
                    .flatMap(i -> lottoResultNumber.getNumbers().stream()
                            .map(j -> new int[] { i, j } ))
                    .filter(array -> array[0] == array[1])
                    .count();

            boolean matchBonus = lottoNumber.getBonus() == lottoResultNumber.getBonus();

            winningCountMap.addCount(Rank.of((int) count, matchBonus));
        }
    }

    public WinningCountMap getWinningCountMap() {
        return winningCountMap;
    }

    public double calculateEarningsRate() {

        int earningMoney = winningCountMap.getAllWinningMoney();
        return (double)earningMoney / (double)money;
    }
}
