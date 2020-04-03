package lotto.util;

import java.util.Scanner;

public class ScannerUtil {
    private static final String WARNING_INTEGER_FORMAT = "숫자만 입력 가능합니다.";
    private static final String WARNING_NULL_AND_EMPTY = "공백 또는 빈문자열은 입력할 수 없습니다.";
    private static final Scanner scanner = new Scanner(System.in);

    public static String readLine() {
        String stringInput = scanner.nextLine();
        validateNullAndEmpty(isNullOrEmpty(stringInput));
        return stringInput;
    }

    public static int readInt(){
        String stringInput = scanner.nextLine();
        validateNullAndEmpty(isNullOrEmpty(stringInput));
        return convertStringToInteger(stringInput);
    }

    private static boolean isNullOrEmpty(String input) {
        return (input.isEmpty() || input == null);
    }

    private static void validateNullAndEmpty(boolean isNullOrEmpty) {
        if (isNullOrEmpty) {
            throw new IllegalArgumentException(WARNING_NULL_AND_EMPTY);
        }
    }

    private static void validateIntegerType(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WARNING_INTEGER_FORMAT);
        }
    }

    private static int convertStringToInteger(String input){
        validateIntegerType(input);
        return Integer.parseInt(input);
    }
}
