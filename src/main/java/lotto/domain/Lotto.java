package lotto.domain;

import lotto.dto.LottoStatisticsDto;

import java.util.List;

public class Lotto {

    public static final int LOTTO_PRICE = 1000;

    private LottoNumbers lottoNumbers;
    private int lottoCount;

    public void createLottoNumbers(int purchaseAmount) {
        lottoCount = purchaseAmount / LOTTO_PRICE;
        createLottoNumbers();
    }

    private void createLottoNumbers() {
        lottoNumbers = new LottoNumbers(lottoCount, new RandomNumberCreation());
    }

    public LottoStatisticsDto calculateLottoStatistics(WinningNumber winningNumber) {
        LottoStatistics lottoStatistics = new LottoStatistics();
        return new LottoStatisticsDto(
                lottoStatistics.calculateMatchingCounts(lottoNumbers, winningNumber),
                lottoStatistics.calculateMatchingPrices(),
                lottoStatistics.calculateGrossRateOfEarnings(lottoCount * LOTTO_PRICE)
                );
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
