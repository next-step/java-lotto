package lotto.util;

import java.text.MessageFormat;

public class MessageUtils {
    public static final String LOTTO_RANGE_VALIDATION_MESSAGE =
            MessageFormat.format(
                    "유효한 로또 번호가 아닙니다. {0}~{1} 숫자중 입력 해 주세요.",
                    ConstUtils.MINIMUM_LOTTO_RANGE,
                    ConstUtils.MAXIMUM_LOTTO_RANGE
            );
}
