package step2;

import java.util.Arrays;

public enum LottoRank {

    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 1500000),
    THIRD_PLACE(4, 50000),
    FOURTH_PLACE(3, 5000),
    LOSER(2, 0);

    private int numberOfMatchedToLuckyNumber;
    private int prizeMoney;

    LottoRank(int numberOfMatchedToLuckyNumber, int prizeMoney) {
        this.numberOfMatchedToLuckyNumber = numberOfMatchedToLuckyNumber;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank from(long countMatchedNumbers) {
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.numberOfMatchedToLuckyNumber == countMatchedNumbers)
                .findFirst()
                .orElse(LOSER);
    }

    public int getNumberOfMatchedToLuckyNumber() {
        return numberOfMatchedToLuckyNumber;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
