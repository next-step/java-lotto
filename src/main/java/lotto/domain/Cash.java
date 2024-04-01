package lotto.domain;

public class Cash {

    private static final int MINIMUM_MONEY = 1000;
    private final int money;

    public Cash(int money) {
        this.money = money;
    }

    public int getAmount() {
        if (money < MINIMUM_MONEY) {
            throw new IllegalArgumentException("로또 금액은 1000원 이상이어야 합니다.");
        }
        return money / MINIMUM_MONEY;
    }

    public int minus(Integer count) {
        int result = getAmount() - count;
        if(result < 0){
            throw new IllegalArgumentException("수동 입력 개수는 전체 개수를 초과할 수 없습니다.");
        }
        return result;
    }

    public int getMoney() {
        return money;
    }
}
