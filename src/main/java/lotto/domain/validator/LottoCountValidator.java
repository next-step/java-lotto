package lotto.domain.validator;

public final class LottoCountValidator extends NumberValidator {

    @Override
    public void validate(String input) {
        checkNumeric(input);
        checkPositive(input);
    }
}
