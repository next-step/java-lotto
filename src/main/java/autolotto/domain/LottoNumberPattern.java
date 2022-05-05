package autolotto.domain;

import java.util.regex.Pattern;

public class LottoNumberPattern {
    private static final Pattern LOTTO_NUMBER_PATTERN = Pattern.compile("[1-9]|1[0-9]|2[0-9]|3[0-9]|4[0-5]");

    public boolean match(String number) {
        return LOTTO_NUMBER_PATTERN.matcher(number).matches();
    }
}
