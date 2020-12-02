package lotto.domain;

import java.util.Objects;

public class PrizeLotto {

    private Lotto prizeLotto;
    private LottoNumber bonusBall;

    public PrizeLotto(Lotto prizeLotto, int bonusBall) {
        this.prizeLotto = prizeLotto;
        this.bonusBall = LottoNumber.from(bonusBall);
    }

    public boolean matchBonusBall(LottoNumber lottoNumber) {
        return bonusBall.equals(lottoNumber);
    }

    public boolean matchLottoNumber(LottoNumber lottoNumber) {
        return prizeLotto.getLottoNumbers()
                                .stream()
                                .anyMatch(number -> number.equals(lottoNumber));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrizeLotto that = (PrizeLotto) o;
        return Objects.equals(prizeLotto, that.prizeLotto) &&
                Objects.equals(bonusBall, that.bonusBall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prizeLotto, bonusBall);
    }
}