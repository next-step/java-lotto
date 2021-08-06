package step2.domain.lotto;

import java.util.Arrays;

public enum LottoNumber {
    THREE_MATCHES(3, 5000),
    FOUR_MATCHES(4, 50000),
    FIVE_MATCHES(5, 1500000),
    SIX_MATCHES(6, 2000000000);

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
            .orElseThrow(() -> new IllegalArgumentException("맞은 개수를 찾을 수 없습니다."));
    }

    public Integer getWinMoney() {
        return winMoney;
    }

    public Integer getNumber() {
        return number;
    }

}
