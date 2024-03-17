public class Calculator {

    private Calculator() {
    }

    public static int calculate(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException("입력 값은 null이거나 공백일 수 없습니다.");
        }

        return 0;
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }
}
