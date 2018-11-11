package net.chandol.lotto.domain;

import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;
    private LottoNumber lottoNumber;

    public Lotto(LottoNumber lottoNumber) {
        if (lottoNumber == null) {
            throw new IllegalArgumentException("null은 허용되지 않습니다.");
        }

        this.lottoNumber = lottoNumber;
    }

    public LottoPrize getMatchingLottoPrize(WinningNumber winningNumber) {
        LottoNumber lottoNumber = winningNumber.getLottoNumber();
        List<Integer> matchNumbers = this.lottoNumber.getMatchNumbers(lottoNumber);

        Integer bonusNumber = winningNumber.getBonusNumber();
        boolean isMatchBonusNumber = this.lottoNumber.containsNumber(bonusNumber);

        return LottoPrize.getMatchingPrize(matchNumbers.size(), isMatchBonusNumber);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumber.getLottoNumbers();
    }
}
