package lotto.dto;

public class RequestDTO {
    private static final int PER_PRICE = 1000;
    private final int money;
    private final int totalAmount;

    public RequestDTO(int money) {
        checkMoney(money);

        this.money = money;
        this.totalAmount = money / PER_PRICE;
    }

    private void checkMoney(int money) {
        if(money % 1000 > 0 ) {
            throw new IllegalArgumentException("천원 단위로 입력해주세요.");
        }
    }

    public int getMoney() {
        return money;
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}
