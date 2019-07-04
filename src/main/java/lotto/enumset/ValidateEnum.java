package lotto.enumset;

import java.util.regex.Pattern;

public enum ValidateEnum {

    NUMBER_FORMAT_VALIDATE("^[0-9]*$");

    public boolean isInValid(String target) {
        return !Pattern.matches(this.regex, target);
    }

    ValidateEnum(String regex) {
        this.regex = regex;
    }

    private String regex;

}
