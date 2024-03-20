package lotto.domain;

public class Cash {

    private int amount;

    public Cash(){}
    public Cash(int amount) {
        this.amount = amount;
    }

    public int payLotto(int money){
        if(money < 1000) throw new IllegalArgumentException();
        return this.amount = money/1000;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("%d개를 구매했습니다.", amount);
    }
}
