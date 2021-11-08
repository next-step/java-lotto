package lotto.utils;

public final class Preconditions {
    private Preconditions() {
        throw new IllegalStateException("Preconditions 직접 생성 금지");
    }

    public static <T> void checkNotNull(T reference, Object errorMessage) {
        if (reference == null) {
            throw new NullPointerException(String.valueOf(errorMessage));
        }
    }

    public static void checkMinimumNumber(int number, int minimumNumber, Object errorMessage) {
        if (number < minimumNumber) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }

    public static void checkMaximumNumber(int number, int maximumNumber, Object errorMessage) {
        if (number > maximumNumber) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
    }
}
