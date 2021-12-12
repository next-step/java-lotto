package stringcaculator.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class StringToIntegerValue implements Value{
    private final static String NUMBER_REGEX = "[0-9]+";

    private final String value;

    public StringToIntegerValue(String value) {
        //생성자에 로직을 넣으면 안되는데 여기에 숫자인지 판단하는 로직을 넣어도 될지
        if(!Pattern.matches(NUMBER_REGEX, value)) {
            throw new IllegalArgumentException("계산기는 숫자 계산만을 지원합니다.");
        }

        this.value = value;
    }

    public Value sum(Value value) {
        int result = this.intValue() + value.intValue();
        return new StringToIntegerValue(Integer.toString(result));
    }

    @Override
    public int intValue() {
        return Integer.parseInt(this.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StringToIntegerValue)) return false;
        StringToIntegerValue that = (StringToIntegerValue) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}