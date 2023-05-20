package lotto.domain;

public enum Rank {

    FIRST(6, 2000000000, 0),
    SECOND(5, 1500000, 0),
    THIRD(4, 5000, 0),
    FOURTH(3, 5000, 0),
    MISS(0, 0, 0);

    private int match;
    private int money;
    private int count;

    private Rank(int match, int money, int count){
        this.match = match;
        this.money = money;
        this.count = count;
    }

    public void addCount(){
        count++;
    }

    public int getCount(){
        return count;
    }

    public int getMoney(){
        return money;
    }

    public int getTotelMoney(){
        return money * count;
    }


}
