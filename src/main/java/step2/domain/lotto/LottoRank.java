package step2.domain.lotto;

import java.util.Arrays;

public enum LottoRank {
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    FIVE_BONUS_MATCH(5, 30_000_000),
    SIX_MATCH(6, 2_000_000_000),
    ZERO_MATCH(0, 0);

    private final int number;
    private final int winMoney;


    LottoRank(int number, int winMoney) {
        this.number = number;
        this.winMoney = winMoney;
    }

    public static LottoRank find(int number, boolean matchBonus) {
        LottoRank lottoNumber = Arrays.stream(LottoRank.values())
            .filter(lottoRank -> lottoRank.number == number)
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("맞은 개수를 찾을 수 없습니다."));

        if (lottoNumber.getNumber() == 5 && matchBonus) {
            return FIVE_BONUS_MATCH;
        }

        return lottoNumber;
    }

    public int getWinMoney() {
        return winMoney;
    }

    public int getNumber() {
        return number;
    }
}
