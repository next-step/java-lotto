package stringcalculator.utils;

public class DataParser {

    public static int parseStrToInt(String stringNumber) {
        int parsed = Integer.parseInt(stringNumber);
        if (parsed < 0) {
            throw new NumberFormatException("음수는 계산할 수 없습니다.");
        }
        return parsed;
    }

}
