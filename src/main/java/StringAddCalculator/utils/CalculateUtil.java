package StringAddCalculator.utils;

public class CalculateUtil {
    public static int getTotalNumber(int total, String[] numberArr) {
        for (String number : numberArr) {
            int essence = Integer.parseInt(number);
            getCheckRuntimeException(essence);
            total += essence;
        }
        return total;
    }

    private static void getCheckRuntimeException(int essence) {
        if (essence < 0) {
            throw new RuntimeException("음수나 숫자 이외의 값은 계산할 수가 없습니다.");
        }
    }
}
