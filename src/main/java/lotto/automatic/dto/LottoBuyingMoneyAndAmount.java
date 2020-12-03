package lotto.automatic.dto;

public class LottoBuyingMoneyAndAmount {

    private static final int LOTTO_PRICE = 1000;
    private final int lottoAmount;
    private final int investMoney;
    private final int changeMoney;
    private final int manualAmount;

    public LottoBuyingMoneyAndAmount(int money) {
        this(money, 0);
    }

    public LottoBuyingMoneyAndAmount(int money, int manualAmount) {

        validateMoney(money);

        this.lottoAmount = money / LOTTO_PRICE;
        this.investMoney = lottoAmount * LOTTO_PRICE;
        this.changeMoney = money - investMoney;

        validateManualAmount(manualAmount);

        this.manualAmount = manualAmount;
    }

    private void validateMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("금액이 모자랍니다.");
        }
    }

    private void validateManualAmount(int manualAmount) {
        if ( manualAmount < 0 || manualAmount > lottoAmount) {
            throw new IllegalArgumentException("올바른 수동 구매 수를 입력해주세요.");
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

    public int getManualAmount() {
        return manualAmount;
    }

    public int getAutoAmount() {
        return lottoAmount - manualAmount;
    }
}
