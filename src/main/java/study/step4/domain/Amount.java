package study.step4.domain;

public class Amount {
    private static final int LOTTO_PRICE = 1000;
    private final int amount;
    private final int manualCount;

    public Amount(int amount) {
        this(amount, 0);
    }

    public Amount(String amount) {
        this(Integer.parseInt(amount), 0);
    }

    public Amount(String amount, String manual){
        this(Integer.parseInt(amount.trim()), Integer.parseInt(manual.trim()));
    }

    public Amount(int amount, int manualCount) {
        this.amount = this.validAmount(amount);
        this.manualCount = this.validManualCount(manualCount);
    }

    private int validAmount(int amount) {
        if ((amount < 0) || (amount % LOTTO_PRICE != 0)) {
            throw new IllegalArgumentException("로또 구매 최저 금액은 " + LOTTO_PRICE + "원 입니다.");
        }
        return amount;
    }

    private int validManualCount(int manualCount) {
        if(manualCount < 0) {
            throw new IllegalArgumentException("구매할 수동 로또 수가 0개 이상이여야 합니다.");
        }
        if(totalCount() - manualCount < 0) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수가 구입금액 보다 큽니다.");
        }
        return manualCount;
    }

    public int totalCount() {
        return amount / LOTTO_PRICE;
    }

    public int getAutoCount() {
        return totalCount() - this.manualCount;
    }

    public int getAmount() {
        return amount;
    }

    public int getManualCount() {
        return manualCount;
    }
}
