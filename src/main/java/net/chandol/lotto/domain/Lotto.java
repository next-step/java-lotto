package net.chandol.lotto.domain;

public class Lotto {
    public static final Money LOTTO_PRICE = Money.of(1000);
    private LottoNumber lottoNumber;

    public Lotto(LottoNumber lottoNumber) {
        if (lottoNumber == null) {
            throw new IllegalArgumentException("null은 허용되지 않습니다.");
        }

        this.lottoNumber = lottoNumber;
    }

    public LottoPrize getMatchingLottoPrize(WinningNumber winningNumber) {
        return winningNumber.findPrize(this.lottoNumber);
    }

    public LottoNumber getLottoNumber() {
        return lottoNumber;
    }
}
