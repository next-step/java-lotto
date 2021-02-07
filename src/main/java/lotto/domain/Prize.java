package lotto.domain;

import java.util.List;

public enum Prize {
    //    3개 일치 (5000원)- 1개
    //4개 일치 (50000원)- 0개
    //5개 일치 (1500000원)- 0개
    //5개 일치, 보너스 볼 일치(30000000원) - 0개
    //6개 일치 (2000000000원)- 0개

    ZERO(0,0),
    ONE(1,0),
    TWO(2,0),
    THREE(3,5000),
    FOUR(4,50000),
    FIVE(5,1500000),
    FIVE_WITH_BONUS(5,30000000),
    SIX(6,2000000000);

    private final int matchedNumber;
    private final int cash;

    Prize(final int matchedNumber, final int cash) {
        this.matchedNumber = matchedNumber;
        this.cash = cash;
    }

    public int getMatchedNumber() {
        return matchedNumber;
    }

    public int getCash() {
        return cash;
    }



    @Override
    public String toString() {
        return "Prize{" +
                "matchedNumber=" + matchedNumber +
                ", cash=" + cash +
                '}';
    }

    private static Prize getPrizeByOnlyMatchedNumber(int matchedNumber) {
        for(Prize prize : Prize.values()) {
            if (matchedNumber == prize.matchedNumber) {
                return prize;
            }
        }
        throw new IllegalArgumentException("no matched prize");
    }

    public static Prize getPrizeByMatchedNumber(final int matchedNumber,boolean isBonus) {
        Prize returnPrize = getPrizeByOnlyMatchedNumber(matchedNumber);
        if (returnPrize.matchedNumber == Prize.FIVE.matchedNumber && isBonus) {
            return Prize.FIVE_WITH_BONUS;
        }
        return returnPrize;

    }

//    public static boolean isFiveWithBonus(final int matchedNumber,Lotto lotto,LottoNumber bonusBall) {
////        List<LottoNumber> lottoNumbers = lotto.getNumbers();
//        return matchedNumber == Prize.FIVE.matchedNumber && lotto.contains(bonusBall);
//    }

}
