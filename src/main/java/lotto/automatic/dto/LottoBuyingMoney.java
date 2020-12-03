package lotto.automatic.dto;

public class LottoBuyingMoney {

    private static final int LOTTO_PRICE = 1000;
    private final int lottoAmount;
    private final int investMoney;
    private final int changeMoney;

    public LottoBuyingMoney(int money) {

        validate(money);

        this.lottoAmount = money / LOTTO_PRICE;
        this.investMoney = lottoAmount * LOTTO_PRICE;
        this.changeMoney = money - investMoney;
    }

    private void validate(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("금액이 모자랍니다.");
        }
    }

    public int getCountOfLotto() {
        return lottoAmount;
    }

    public int getInvestMoney() {
        return investMoney;
    }

    public int getChangeMoney() {
        return changeMoney;
    }
}
