package lotto.dto;

import lotto.exception.IllegalManuallyPurchasingLottoCountExcepion;

import static java.lang.Integer.parseInt;

public class ManuallyPurchasingLottoCount {
    private final int value;
    private int count;

    public ManuallyPurchasingLottoCount(String value) {
        validateIllegalCharacter(value);

        int parsedValue = parseInt(value);
        validateValueBoundary(parsedValue);

        this.value = parsedValue;
        this.count = 0;
    }

    public boolean remainBuyableManualLottoCount() {
        if (count < value) {
            count++;
            return true;
        }
        return false;
    }

    private void validateIllegalCharacter(String value) {
        try {
            parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalManuallyPurchasingLottoCountExcepion();
        }
    }

    private void validateValueBoundary(int value) {
        if (value <= 0) {
            throw new IllegalManuallyPurchasingLottoCountExcepion();
        }
    }

    public int getValue() {
        return this.value;
    }
}
