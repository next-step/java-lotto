package lotto.view.input;

import lotto.domain.product.lotto.LotteryTicket;
import lotto.domain.product.lotto.LottoNumber;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class BaseInputView implements InputView {

    private static final String NUMBER_INPUT_DELIMITER = ", ";
    private static final String TICKET_INPUT_DELIMITER = ",";

    public Set<LottoNumber> parseToLottoNumbers(String input) {
        return Arrays.stream(input.split(NUMBER_INPUT_DELIMITER))
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    protected LotteryTicket getTicket(String input) {
        return new LotteryTicket(parseInput(input));
    }

    public Set<LottoNumber> parseInput(String input) {
        return Arrays.stream(input.split(TICKET_INPUT_DELIMITER))
                .map(String::trim)
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }
}
