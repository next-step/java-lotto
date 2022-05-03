package domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum LottoRank {
    SIX_NUMBERS(6,2000000000),
    FIVE_NUMBERS_AND_BONUS(5,30000000),
    FIVE_NUMBERS(5,1500000),
    FOUR_NUMBERS(4,50000),
    THREE_NUMBERS(3,5000);

    private final int lottoRank;
    private final int lottoRankMoney;

    LottoRank(int lottoRank, int lottoRankMoney) {
        this.lottoRank = lottoRank;
        this.lottoRankMoney = lottoRankMoney;
    }

    public int getLottoRankMoney() {
        return lottoRankMoney;
    }

    public int getLottoRank() {
        return lottoRank;
    }

    public static LottoRank valueOf(int lottoRankMoney) {
        try {
            return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.getLottoRankMoney() == lottoRankMoney)
                .collect(Collectors.toList())
                .get(0);
        } catch(IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("조회할 금액에 해당하는 로또 등수가 존재하지 않습니다.");
        }
    }

}
