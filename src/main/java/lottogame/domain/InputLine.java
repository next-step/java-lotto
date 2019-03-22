package lottogame.domain;

import lottogame.util.StringUtils;
import lottogame.validator.InputLineValidator;
import lottogame.validator.Validatable;

public class InputLine {

    private final String line;

    private final Validatable<String> validator = new InputLineValidator();

    public InputLine(String line) {
        validator.validate(line);
        this.line = StringUtils.removeWhitespace(line);
    }

    public String getLine() {
        return line;
    }
}