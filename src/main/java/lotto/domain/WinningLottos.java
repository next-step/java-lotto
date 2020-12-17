package lotto.domain;

import lotto.util.NumberUtil;

public class WinningLottos {

    private final static int MATCH_THREE = 3;
    private final static int MATCH_FOUR = 4;
    private final static int MATCH_FIVE = 5;
    private final static int MATCH_SIX = 6;

    private final static long MATCH_THREE_MONEY = 5000;
    private final static long MATCH_FOUR_MONEY = 50000;
    private final static long MATCH_FIVE_MONEY = 1500000;
    private final static long MATCH_SIX_MONEY = 2000000000;

    private int matchThreeNumberOfCount = 0;
    private int matchFourNumberOfCount = 0;
    private int matchFiveNumberOfCount = 0;
    private int matchSixNumberOfCount = 0;

    public int getNumberOfMatchThree() {
        return matchThreeNumberOfCount;
    }

    public int getNumberOfMatchFour() {
        return matchFourNumberOfCount;
    }

    public int getNumberOfMatchFive() {
        return matchFiveNumberOfCount;
    }

    public int getNumberOfMatchSix() {
        return matchSixNumberOfCount;
    }

    public int addMatchingNumber(int matchNumber) {
        if (matchNumber == MATCH_THREE) {
            matchThreeNumberOfCount = matchThreeNumberOfCount + 1;
            return matchThreeNumberOfCount;
        }
        if (matchNumber == MATCH_FOUR) {
            matchFourNumberOfCount = matchFourNumberOfCount + 1;
            return matchFourNumberOfCount;
        }
        if (matchNumber == MATCH_FIVE) {
            matchFiveNumberOfCount = matchFiveNumberOfCount + 1;
            return matchFiveNumberOfCount;
        }
        if (matchNumber == MATCH_SIX) {
            matchSixNumberOfCount = matchSixNumberOfCount + 1;
            return matchSixNumberOfCount;
        }
        return 0;
    }

    public long amountOfWinning() {

        long thridMatchMoney = MATCH_THREE_MONEY * matchThreeNumberOfCount;
        long fourthMatchMoney = MATCH_FOUR_MONEY * matchFourNumberOfCount;
        long fifthMatchMoney = MATCH_FIVE_MONEY * matchFiveNumberOfCount;
        long sixMatchMoney = MATCH_SIX_MONEY * matchSixNumberOfCount;

        return thridMatchMoney + fourthMatchMoney + fifthMatchMoney + sixMatchMoney;
    }

    public float calcurateRevenue(String money) {
        long inputMoney = NumberUtil.stringTolong(money);
        long winningMoney = this.amountOfWinning();
        if (winningMoney == 0) {
           return  0;
        }
        float revenu =  winningMoney / inputMoney;
        return revenu;
    }
}
