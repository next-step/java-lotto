package lotto.domain;

public class LottoRecord {
    public static final int WON = 1000;
    public static final int NULL = 0;

    private int countThree = 0;
    private int countFour = 0;
    private int countFive = 0;
    private int countFiveAndBonus = 0;
    private int countSix = 0;
    private int profit = 0;

    public int getCountThree(){
        return countThree;
    }

    public int getCountFour(){
        return countFour;
    }

    public int getCountFive(){
        return countFive;
    }

    public int getcountFiveAndBonus(){
        return countFiveAndBonus;
    }

    public int getCountSix(){
        return countSix;
    }

    public int getProfit(){
        return profit;
    }


    public void setCountThree(){
        this.countThree += 1;
    }

    public void setCountFour(){
        this.countFour += 1;
    }

    public void setCountFive(){
        this.countFive += 1;
    }

    public void setcountFiveAndBonus(){
        this.countFiveAndBonus += 1;
    }

    public void setCountSix(){
        this.countSix += 1;
    }

    public void calculatorProfit(int size){
        int money = size * WON;
        int temp = 0;

        if (countThree != NULL) {
            temp += countThree * Rank.valueOf(3, false).getWinningMoney();
        }

        if (countFour != NULL) {
            temp += countFour * Rank.valueOf(4, false).getWinningMoney();
        }

        if (countFive != NULL) {
            temp += countFive * Rank.valueOf(5, false).getWinningMoney();
        }

        if (countFiveAndBonus != NULL) {
            temp += countFiveAndBonus * Rank.valueOf(5, true).getWinningMoney();
        }

        if (countSix != NULL) {
            temp += countSix * Rank.valueOf(6, false).getWinningMoney();
        }

        this.profit = temp / money;
    }
}