package lotto.domain;

import lotto.exception.InvalidNumberOfManualLottoToPurchase;

public class NumberOfManualLottoToPurchase {
    private final int numberOfManualLottoToPurchase;

    private NumberOfManualLottoToPurchase(int numberOfManualLottoToPurchase, int maximumNumberOfManualLottoToPurchase) {
        validateNumberOfManualLottoToPurchase(numberOfManualLottoToPurchase, maximumNumberOfManualLottoToPurchase);
        this.numberOfManualLottoToPurchase = numberOfManualLottoToPurchase;
    }

    private void validateNumberOfManualLottoToPurchase(int numberOfManualLottoToPurchase, int maximumNumberOfManualLottoToPurchase) {
        if(numberOfManualLottoToPurchase < 0 || numberOfManualLottoToPurchase > maximumNumberOfManualLottoToPurchase) {
            throw new InvalidNumberOfManualLottoToPurchase(numberOfManualLottoToPurchase);
        }
    }

    public static NumberOfManualLottoToPurchase newNumberOfManualLottoToPurchase(int numberOfManualLottoToPurchase, int maximumNumberOfManualLottoToPurchase) {
        return new NumberOfManualLottoToPurchase(numberOfManualLottoToPurchase, maximumNumberOfManualLottoToPurchase);
    }

    public int number() {
        return numberOfManualLottoToPurchase;
    }
}
