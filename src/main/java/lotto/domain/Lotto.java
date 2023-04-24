package lotto.domain;

import lotto.dto.LottoStaticsDto;

import java.util.List;

public class Lotto {

    public static final int LOTTO_PRICE = 1000;
    private LottoNumbers lottoNumbers;
    private LottoNumber winningNumber;
    private int lottoCount;
    private NumberCreationStrategy strategy;

    public Lotto(NumberCreationStrategy strategy) {
        this.strategy = strategy;
    }

    public void createLottoNumbers(int purchaseAmount) {
        lottoCount = purchaseAmount / LOTTO_PRICE;
        createLottoNumbers();
    }

    private void createLottoNumbers() {
        lottoNumbers = new LottoNumbers(lottoCount, strategy);
    }

    public void createWinningNumber(List<Integer> winningNumber) {
        this.winningNumber = new LottoNumber(winningNumber);
    }

    public LottoStaticsDto calculateLottoStatics() {
        LottoStatics lottoStatics = new LottoStatics();
        return new LottoStaticsDto(
                lottoStatics.calculateMatchingCounts(lottoNumbers, winningNumber),
                lottoStatics.calculateMatchingPrices(),
                lottoStatics.calculateGrossRateOfEarnings(lottoCount * LOTTO_PRICE)
                );
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
