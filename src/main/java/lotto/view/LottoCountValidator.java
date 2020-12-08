package lotto.view;

public final class LottoCountValidator extends NumberValidator {

    @Override
    protected void validate(String input) {
        checkNumeric(input);
        checkPositive(input);
    }
}
