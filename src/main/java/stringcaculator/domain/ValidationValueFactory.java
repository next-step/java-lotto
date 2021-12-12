package stringcaculator.domain;

import java.util.regex.Pattern;

public class ValidationValueFactory implements ValueFactory{
    private final static String NUMBER_REGEX = "[0-9]+";

    @Override
    public Value create(String value) {
        if(!Pattern.matches(NUMBER_REGEX, value)) {
            throw new IllegalArgumentException("계산기는 숫자 계산만을 지원합니다.");
        }

        return new StringToIntegerValue(value);
    }

}
