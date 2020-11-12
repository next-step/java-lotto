package study.calculator.argument;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import study.calculator.Number;

/**
 * Null이거나 빈 문자열
 */
public class BlankArgument implements Argument{

    public static boolean isBlankArgument(String source) {
        if (Objects.isNull(source)) {
            return true;
        }

        return source.trim().isEmpty();
    }

    @Override
    public List<Number> parseToNumber() {
        return new ArrayList<>();
    }

}
