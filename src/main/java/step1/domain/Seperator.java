package step1.domain;

import step1.exception.EmptyStringException;

public class Seperator {

    public static void validate(String text) {
        if (text == null || text.isEmpty()) {
            throw new EmptyStringException();
        }
    }

}
