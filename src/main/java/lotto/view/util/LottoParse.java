package lotto.view.util;

import java.util.Optional;

public class LottoParse {

    public static String[] stringToLottoStringNumber(String value) {
        return value.split("\r\n");
//        return Optional.ofNullable(value.split("\r\n")).orElseThrow(IllegalArgumentException::new);
    }
}
