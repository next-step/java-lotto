package lotto.domain;

public class LottoRecord {
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
        int money = size * 1000;
        int temp = 0;

        if(countThree != 0){
            temp += countThree * 5000;
        }

        if(countFour != 0){
            temp += countFour * 50000;
        }

        if(countFive != 0){
            temp += countFive * 1500000;
        }

        if(countSix != 0){
            temp += countSix * 200000000;
        }

        this.profit = temp / money;
    }
}