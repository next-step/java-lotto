package lotto.domain;

public class ValidationUtils {

    public static boolean isValidPrice(int price) {
        return price >= 1000;
    }

    public static boolean isValidLottoNumberBoundary(int number) {
        return number >= 1 && number <= 45;
    }
}
