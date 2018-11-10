package net.chandol.lotto.domain;

import java.util.List;

public class Lotto {
    private LottoNumber lottoNumber;

    public Lotto(LottoNumber lottoNumber) {
        if (lottoNumber == null) {
            throw new IllegalArgumentException("null은 허용되지 않습니다.");
        }

        this.lottoNumber = lottoNumber;
    }

    public int getMatchCount(LottoNumber another) {
        List<Integer> matchNumbers = lottoNumber.getMatchNumbers(another);
        return matchNumbers.size();
    }
}
