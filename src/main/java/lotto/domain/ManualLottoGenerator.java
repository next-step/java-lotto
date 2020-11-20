package lotto.domain;

import lotto.utils.MessageUtils;
import lotto.view.Input;
import lotto.view.InputChannel;
import lotto.view.InputView;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ManualLottoGenerator implements LottoGenerator {

    private static final int LOTTO_WINNING_SIZE = 6;
    private static final int LOTTO_WINNING_MINIMUM_NUM = 1;
    private static final int LOTTO_WINNING_MAXIMUM_NUM = 45;
    private static final String EMPTY_VALUE = "";
    private static final String REGEX_DELIMITER_DEFAULT = ",";

    private static final Input inputChannel = new InputChannel();

    @Override
    public Set<LottoNumber> create() {
        return build();
    }

    private Set<LottoNumber> build() {
        return parser(intput());
    }

    protected String intput() {
        String input = InputView.inputManualLotto(inputChannel);
        validate(input);
        return input;
    }

    private Set<LottoNumber> parser(String manualNumber) {
        return Arrays.stream(manualNumber.split(REGEX_DELIMITER_DEFAULT))
                .map(Integer::parseInt)
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    private void validate(String manualNumber) {
        validateNotEmpty(manualNumber);
        String[] manualNumbers = manualNumber.split(REGEX_DELIMITER_DEFAULT);
        validateSize(manualNumbers);
        validateOverMaxNum(manualNumbers);
    }

    private void validateNotEmpty(String winning) {
        if (Objects.isNull(winning) || winning.equals(EMPTY_VALUE)) {
            throw new IllegalArgumentException(MessageUtils.INPUT_NOT_EMPTY);
        }
    }

    private void validateSize(String[] winning) {
        int size = Arrays.stream(winning).collect(Collectors.toSet()).size();
        if (size != LOTTO_WINNING_SIZE) {
            throw new IllegalArgumentException(MessageUtils.INPUT_WINNING_SIZE);
        }
    }

    private void validateOverMaxNum(String[] winning) {
        Arrays.stream(winning)
                .map(Integer::parseInt)
                .filter(this::isNotValidRange)
                .findAny()
                .ifPresent(v -> {
                    throw new IllegalArgumentException(MessageUtils.INPUT_WINNING_INVALID_NUM);
                });
    }

    private boolean isNotValidRange(int num) {
        return num < LOTTO_WINNING_MINIMUM_NUM || num > LOTTO_WINNING_MAXIMUM_NUM;
    }
}
