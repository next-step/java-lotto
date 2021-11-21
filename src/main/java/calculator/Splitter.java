package calculator;

import calculator.util.Assert;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Splitter {

    private static final String DEFAULT_DELIMITER = ",|:";

    public Operands split(String text) {
        return split(text, DEFAULT_DELIMITER);
    }

    public Operands split(String text, String delimiter) {
        Assert.notNull(text, "text는 null일 수 없습니다.");
        Assert.notNull(delimiter, "delimiter는 null일 수 없습니다.");

        return new Operands(Arrays.stream(text.split(delimiter))
                .map(Operand::new)
                .collect(Collectors.toList()));
    }

}
