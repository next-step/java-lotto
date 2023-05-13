package lotto.domain;

public class MyPurchase {
    private static final int PRICE = 1000;
    private final int money;
    private final int autoCount;
    private final int manualCount;

    public MyPurchase(int inputMoney) {
        this(inputMoney, 0);
    }

    public MyPurchase(int inputMoney, int manualCount) {
        validatePurchase(inputMoney, manualCount);
        this.money = inputMoney;
        this.manualCount = manualCount;
        this.autoCount = (inputMoney / PRICE) - manualCount;
    }

    private void validatePurchase(int inputMoney, int manualCount) {
        if (inputMoney < 0) {
            throw new IllegalArgumentException("구매 금액은 0 보다 작을 수 없습니다.");
        }
        if (manualCount < 0) {
            throw new IllegalArgumentException("수동 로또 구매 수는 0 보다 작을 수 없습니다.");
        }
        if (inputMoney < manualCount * PRICE) {
            throw new IllegalArgumentException("수동 로또 구매 수는 총 구매 수 보다 클 수 없습니다.");
        }
    }

    public int money() {
        return money;
    }

    public int count() {
        return autoCount + manualCount;
    }

    public int autoCount() {
        return autoCount;
    }

    public int manualCount() {
        return manualCount;
    }
}
