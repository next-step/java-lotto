package lotto.view.input;

import lotto.domain.product.LottoNumber;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class BaseInputView implements InputView {

    private static final String NUMBER_INPUT_DELIMITER = ", ";

    public Set<LottoNumber> parseToLottoNumbers(String input) {
        return Arrays.stream(input.split(NUMBER_INPUT_DELIMITER))
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    protected Integer parseInt(String input) {
        return Integer.parseInt(input);
    }
}
