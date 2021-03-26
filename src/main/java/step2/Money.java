package step2;

public class Money {

    public static final int DEFAULT_LOTTO_PRICE = 1000;
    private int money;

    public Money(int money) {
        if(money < DEFAULT_LOTTO_PRICE){
            throw new IllegalArgumentException("구매 금액을 정확히 입력해주세요");
        }
        this.money = money;
    }

    public int getMoney(){
        return money;
    }
}
