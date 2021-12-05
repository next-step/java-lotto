package lotto.domain;

import static utils.IntegerValidator.getNumberIfPositive;
import static utils.IntegerValidator.isNumberNegative;

public class Wallet {

    private final int money;

    public Wallet(int money) {
        this.money = getNumberIfPositive(money);
    }

    public Wallet spend(int spendMoney) {
        spendValid(spendMoney);

        int preSpendAmount = money - spendMoney;

        return new Wallet(preSpendAmount);
    }

    public int getNumberOfBuyAvailableLottoTicket(int price) {
        return money / price;
    }

    private void spendValid(int spendMoney) {
        if (isNumberNegative(spendMoney)) {
            throw new IllegalArgumentException("지출금액이 음수일 수 없어요.");
        }

        if (money < spendMoney) {
            throw new IllegalArgumentException("보유금액보다 지출금액이 클 수는 없어요.");
        }
    }


}
