package step4.domain;

import java.util.Arrays;

public enum LottoRank {

    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 30_000_000),
    THIRD_PLACE(5, 1_500_000),
    FOURTH_PLACE(4, 50_000),
    FIFTH_PLACE(3, 5_000),
    LOSER(0, 0);

    private int numberOfMatchedToLuckyNumber;
    private int prizeMoney;

    LottoRank(int numberOfMatchedToLuckyNumber, int prizeMoney) {
        this.numberOfMatchedToLuckyNumber = numberOfMatchedToLuckyNumber;
        this.prizeMoney = prizeMoney;
    }

    public static LottoRank from(LottoTicket lottoTicket, LuckyTicket luckyTicket) {
        int countMatchedNumbers = lottoTicket.getNumberOfMatchedToLuckyNumber(luckyTicket);
        boolean isMatchedToBonusNumber = lottoTicket.isBonusNumberMatched(luckyTicket);

        if ((countMatchedNumbers == SECOND_PLACE.numberOfMatchedToLuckyNumber) && isMatchedToBonusNumber) {
            return LottoRank.SECOND_PLACE;
        }
        return Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.numberOfMatchedToLuckyNumber == countMatchedNumbers)
                .findFirst()
                .orElse(LOSER);
    }

    public int getNumberOfMatchingNumber() {
        return numberOfMatchedToLuckyNumber;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

}
