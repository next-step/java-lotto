package lotto.dto;

import lotto.exception.IllegalLottoNumberCountException;
import lotto.exception.IllegalManuallyPurchasingLottoCountExcepion;

import static java.lang.Integer.parseInt;

public class ManuallyPurchasingLottoCount {
    private int value;

    public ManuallyPurchasingLottoCount(String value) {
        validateIllegalCharacter(value);

        int parsedValue = parseInt(value);
        validateValueBoundary(parsedValue);

        this.value = parsedValue;
    }

    private void validateIllegalCharacter(String value) {
        try {
            parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalManuallyPurchasingLottoCountExcepion();
        }
    }

    private void validateValueBoundary(int value) {
        if(value <= 0) {
            throw new IllegalManuallyPurchasingLottoCountExcepion();
        }
    }

    public int getValue() {
        return this.value;
    }
}
