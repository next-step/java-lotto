package lotto.view.input;

import lotto.domain.product.lotto.LotteryTicket;
import lotto.domain.product.lotto.LottoNumber;

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

    protected static LotteryTicket getTicket(String input) {
        return new LotteryTicket(input);
    }


}
