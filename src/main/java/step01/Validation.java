package step01;

import java.util.List;

import static step01.Config.ZERO;

public class Validation {

    private Validation() {}

    public static boolean isNumberZeroOrEmpty(List<String> values) {
        return values.stream().filter(number -> number.isEmpty() || number.equals(ZERO)).toArray().length > 0;
    }

    public static void checkIsNegative(List<String> values) throws RuntimeException {
        if (values.stream().mapToInt(Integer::parseInt).filter(number -> number < 0).toArray().length > 0) {
            throw new RuntimeException();
        }
    }
}
