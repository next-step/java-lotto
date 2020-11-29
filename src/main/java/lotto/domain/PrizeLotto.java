package lotto.domain;

import java.util.Set;

public class PrizeLotto {

    private LottoNumber lottoNumbers;
    private int bonusBall;

    private PrizeLotto(Set<Integer> lottoNumbers, int bonusBall) {
        this.lottoNumbers = LottoNumber.from(lottoNumbers);
        this.bonusBall = bonusBall;
    }

    public static PrizeLotto of(Set<Integer> lottoNumber, int bonusBall) {
        return new PrizeLotto(lottoNumber, bonusBall);
    }

    public boolean matchBonusBall(int lottoNumber) {
        return lottoNumber == bonusBall;
    }

    public boolean existByLottoNumber(int lottoNumber) {
        return lottoNumbers.getLottoNumber().contains(lottoNumber);
    }

}