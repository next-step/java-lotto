package step2;

public class Money {

    private int money;

    public Money(int money) {
        if(money < 0){
            throw new IllegalArgumentException("구매 금액을 정확히 입력해주세요");
        }
        this.money = money;
    }

    public int getMoney(){
        return money;
    }
}
