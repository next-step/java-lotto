package stringcalculator.utils;

public class Parser {

    public static int parse(String textNumber) {
        validate(textNumber);

        int numeric;

        try {
            numeric = Integer.parseInt(textNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자만 입력이 가능합니다.");
        }

        return numeric;
    }

    public static void validate(String textNumber) {
        if(textNumber == null || "".equals(textNumber)) {
            throw new NumberFormatException("숫자를 입력해주세요.");
        }
    }
}
