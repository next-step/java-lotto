package lotto.domain;

import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;

public class LottoNumber {

    public static final int LOTTO_NUMBER_START = 1;
    public static final int LOTTO_NUMBER_END = 45;

    private static final String NUMBER_BLANK_MESSAGE = "number not allowed null or empty";
    private static final String NUMBER_RANGE_MESSAGE = "number range {0} to {1}";

    private static final Map<Integer, LottoNumber> LOTTO_NUMBERS;

    static {
        LOTTO_NUMBERS = new HashMap<>();
        for (int i = LOTTO_NUMBER_START; i <= LOTTO_NUMBER_END; i++) {
            LOTTO_NUMBERS.put(i, new LottoNumber(i));
        }
    }

    private final int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static LottoNumber of(int number) {
        checkArgument(number >= LOTTO_NUMBER_START && number <= LOTTO_NUMBER_END,
            MessageFormat.format(NUMBER_RANGE_MESSAGE, LOTTO_NUMBER_START, LOTTO_NUMBER_END));
        return LOTTO_NUMBERS.get(number);
    }

    public static LottoNumber of(String text) {
        checkArgument(StringUtils.isNotBlank(text), NUMBER_BLANK_MESSAGE);
        return of(Integer.parseInt(text.trim()));
    }

}
