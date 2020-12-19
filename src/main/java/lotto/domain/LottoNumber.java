package lotto.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;

public class LottoNumber {

    private static final int LOTTO_NUMBER_START = 1;
    private static final int LOTTO_NUMBER_END = 45;
    private static final String NUMBER_RANGE_MESSAGE = "Lotto number range %s to %s but was: %s";
    private static final String INVALID_INPUT_MESSAGE = "Lotto number cannot be null or empty: %s";
    private static final String PARSING_ERROR_MESSAGE = "Input number is not parsable: %s";

    private static final Map<Integer, LottoNumber> NUMBER_BY_VALUE;

    static {
        NUMBER_BY_VALUE = new HashMap<>();
        for (int i = LOTTO_NUMBER_START; i <= LOTTO_NUMBER_END; i++) {
            NUMBER_BY_VALUE.put(i, new LottoNumber(i));
        }
    }

    private final int value;

    private LottoNumber(int value) {
        this.value = value;
    }

    public static LottoNumber of(int number) {
        checkArgument(number >= LOTTO_NUMBER_START && number <= LOTTO_NUMBER_END,
                NUMBER_RANGE_MESSAGE, LOTTO_NUMBER_START, LOTTO_NUMBER_END, number);
        return NUMBER_BY_VALUE.get(number);
    }

    public static LottoNumber of(String input) {
        checkArgument(StringUtils.isNotBlank(input), INVALID_INPUT_MESSAGE, input);
        try {
            return of(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(PARSING_ERROR_MESSAGE, input));
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
