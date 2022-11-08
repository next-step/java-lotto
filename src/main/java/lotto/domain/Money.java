package lotto.domain;

public class Money {
    private static final int lottoPirce = 1000;

    int money;

    public Money(int money) {
       validationNegative(money);
       validationMoney(money);
       this.money = money / lottoPirce;
    }

    public void validationMoney(int money){
        if(money < 1000){
            throw new IllegalArgumentException("1000원 이상을 입력해야합니다.");
        }
    }

    public void validationNegative(int money){
        if(money < 0){
            throw new IllegalArgumentException("음수가 들어왔습니다.");
        }
    }

    public int getMoney() {
        return this.money;
    }
}
