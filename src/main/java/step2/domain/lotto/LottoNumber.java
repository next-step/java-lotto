package step2.domain.lotto;

import java.util.Arrays;

public enum LottoNumber {
    _3_NUMBER(3, 5000),
    _4_NUMBER(4, 50000),
    _5_NUMBER(5, 1500000),
    _6_NUMBER(6, 2000000000);

    private final Integer number;
    private final Integer winMoney;

    LottoNumber(int number, int winMoney) {
        this.number = number;
        this.winMoney = winMoney;
    }

    public static LottoNumber find(Integer number) {
        return Arrays.stream(LottoNumber.values())
            .filter(lottoRank -> lottoRank.number.equals(number))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("랭크를 찾을 수 없습니다."));
    }

    public Integer getWinMoney() {
        return winMoney;
    }

    public Integer getNumber() {
        return number;
    }

}
