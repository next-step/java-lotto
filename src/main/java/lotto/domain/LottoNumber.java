package lotto.domain;

import static lotto.domain.Rule.MAX_NUMBER;
import static lotto.domain.Rule.MIN_NUMBER;

// todo: LottoNumber로 포장
public class LottoNumber {

    private final int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if (lottoNumber < MIN_NUMBER.getNumber() || lottoNumber > MAX_NUMBER.getNumber()) {
            throw new IllegalArgumentException(String.format(
                    "(%d)는 로또번호에 포함되지 않습니다. %d ~ %d까지의 숫자를 입력해주세요."
                    , lottoNumber
                    , MIN_NUMBER.getNumber()
                    , MAX_NUMBER.getNumber()
            ));
        }
        this.lottoNumber = lottoNumber;
    }


}
