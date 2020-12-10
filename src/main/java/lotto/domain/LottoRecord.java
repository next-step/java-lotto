package lotto.domain;

public class LottoRecord {
    public static final int WON = 1000;
    public static final int NULL = 0;

    private int countThree = 0;
    private int countFour = 0;
    private int countFive = 0;
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

    public void setCountSix(){
        this.countSix += 1;
    }

    public void calculatorProfit(int size){
        int money = size * WON;
        int temp = 0;

        if (countThree != NULL) {
            temp += countThree * 5000;
        }

        if (countFour != NULL) {
            temp += countFour * 50000;
        }

        if (countFive != NULL) {
            temp += countFive * 1500000;
        }

        if (countSix != NULL) {
            temp += countSix * 200000000;
        }

        this.profit = temp / money;
    }
}