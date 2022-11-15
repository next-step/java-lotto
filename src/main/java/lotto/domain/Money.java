package lotto.domain;

public class Money {

    private static final String THOUSAND_OF_WON_EXCEPTION = "1000원 단위로 입력해주세요.";
    private static final String THOUSAND_OF_WON_UNDER_EXCEPTION = "1000원 이상을 입력해야합니다.";
    private static final String NEGATIVE_EXCEPTION = "음수가 들어왔습니다.";

    private int money;

    public Money(int money) {
       validationNegative(money);
       validationMoney(money);
       validationThousand(money);
       this.money = money;
    }

    public void validationThousand(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException(THOUSAND_OF_WON_EXCEPTION);
        }
    }

    public void validationMoney(int money){
        if(money < 1000){
            throw new IllegalArgumentException(THOUSAND_OF_WON_UNDER_EXCEPTION);
        }
    }

    public void validationNegative(int money){
        if(money < 0){
            throw new IllegalArgumentException(NEGATIVE_EXCEPTION);
        }
    }

    public int getMoney() {
        return this.money;
    }
}
