package Lotto;

public class Amount {

    private int amount;

    public Amount(String amountStr) {
        int tempAmount = 0;
        try {
            tempAmount = Integer.parseInt(amountStr);
        } catch (NumberFormatException e) {
            e.addSuppressed(new IllegalArgumentException("숫자가 아닌 값을 입력하였습니다."));
        }

        if (tempAmount < 0) {
            throw new RuntimeException("입력값은 음수가 될 수 없습니다.");
        } else if (tempAmount < 1000) {
            throw new RuntimeException("로또 구매를 위한 최소 금액은 1000원입니다.");
        }

        this.amount = tempAmount;
    }

    public int getAmount() {
        return this.amount;
    }
}
