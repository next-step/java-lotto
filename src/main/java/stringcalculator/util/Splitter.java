package stringcalculator.util;

public class Splitter {

    private static final String DEFAULT_SPLIT_REGEX = " ";

    private Splitter() {

    }

    public static String[] splitString(String inpuString) {
        validate(inpuString);
        return inpuString.split(DEFAULT_SPLIT_REGEX);
    }

    private static void validate(String inpuString) {
        if (isEmpty(inpuString)) {
            throw new IllegalArgumentException("비어 있는 값은 입력할 수 없습니다.");
        }
    }

    private static boolean isEmpty(String inputString) {
        return inputString == null || inputString.isBlank();
    }
}
