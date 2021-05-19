package lotto.domain;

public class ValidationUtils {

    public static boolean isValidPrice(int price) {
        return price >= 1000;
    }
}
