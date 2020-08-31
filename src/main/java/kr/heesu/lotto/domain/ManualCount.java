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
        if (!isNumeric(input)) {
            throw new IllegalArgumentException();
        }

        int manulSize = Integer.parseInt(input);
        if (purchaseAmount.getSize() - manulSize < 0) {
            throw new IllegalArgumentException();
        }

        return manulSize;
    }

    private static boolean isNumeric(String input) {
        if (input == null) {
            return false;
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }

    public int getSize() {
        return this.size;
    }
}
