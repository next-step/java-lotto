package lotto.view.input;

import lotto.domain.product.LottoNumber;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class BaseInputView implements InputView {

    private static final String NUMBER_INPUT_DELIMITER = ", ";

    protected Set<LottoNumber> parseToLottoNumbers(String input) {
        return Arrays.stream(input.split(NUMBER_INPUT_DELIMITER))
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }
}
