package calculator.util;

import java.util.Optional;

public class Converter {

    private Converter() {
    }

    public static int stringToInteger(String value) {
        return Optional
                .of(Integer.parseInt(value))
                .orElseThrow(() -> new IllegalArgumentException("숫자가 아닌 문자열은 사용할 수 없습니다."));
    }
}
