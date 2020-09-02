package kr.heesu.lotto.domain;

public class ManualCount {

    private final int size;

    public ManualCount(int size) {
        this.size = size;
    }

    public static ManualCount of(String input, PurchaseAmount purchaseAmount) throws NumberFormatException {
        int size = validationCheck(input, purchaseAmount);
        return new ManualCount(size);
    }

    private static int validationCheck(String input, PurchaseAmount purchaseAmount) {
        int manulSize = Integer.parseInt(input);
        if (purchaseAmount.getSize() - manulSize < 0) {
            throw new IllegalArgumentException();
        }

        return manulSize;
    }

    public int getSize() {
        return this.size;
    }
}
