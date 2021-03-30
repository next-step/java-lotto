package lotto.util;

import java.util.Arrays;

import static lotto.domain.LottoStrategy.LOTTO_SIZE;
import static lotto.util.Message.ILLEGAL_LOTTO_SIZE;
import static lotto.util.Message.OVERLAP_NUMBER;

public class StringUtil {

    public static final String DELIMITER = ", ";

    public static boolean checkNumberSize(String[] result) {
        if (result.length != LOTTO_SIZE) {
            throw new IllegalArgumentException(ILLEGAL_LOTTO_SIZE);
        }
        return true;
    }

    public static boolean checkNumberOverlap(String[] result) {
        if(Arrays.stream(result)
                .distinct()
                .count() != result.length) {
            throw new IllegalArgumentException(OVERLAP_NUMBER);
        }
        return true;
    }
}
