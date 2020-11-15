package lotto.dto;

import lotto.exception.IllegalNumberOfManualLottoInputException;
import lotto.exception.OverAmountException;

public class NumberOfManualLotto {
    private static final String INVALID_NUMBER_ERR_MSG = "음수는 입력될 수 없습니다.";
    public static final String INVALID_SIZE_ERR_MSG = "입력된 금액보다 더 많은 로또를 구입 할 수 없습니다.";

    private final int numberOfManualLotto;

    private NumberOfManualLotto(int numberOfManualLotto) {
        this.numberOfManualLotto = numberOfManualLotto;
    }

    public static NumberOfManualLotto valueOf(int numberOfManualLotto) {
        validateInput(numberOfManualLotto);
        return new NumberOfManualLotto(numberOfManualLotto);
    }

    private static void validateInput(int numberOfManualLotto) {
        if (numberOfManualLotto < 0) {
            throw new IllegalNumberOfManualLottoInputException(INVALID_NUMBER_ERR_MSG);
        }
    }

    public void validateSize(Amount amount) {
        if (amount.isInvalidNumberOfManualLottoSize(numberOfManualLotto)) {
            throw new OverAmountException(INVALID_SIZE_ERR_MSG);
        }
    }

    public boolean isZero() {
        return numberOfManualLotto == 0;
    }

    public void repeatAsSize(Runnable runnable) {
        for (int i = 0; i < numberOfManualLotto; i++) {
            runnable.run();
        }
    }
}
