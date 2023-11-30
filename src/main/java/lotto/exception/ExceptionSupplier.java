package lotto.exception;

public interface ExceptionSupplier<T> {

    T get();

    default T handleException() {
        try {
            return get();
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return handleException();
        }
    }

    static <T> T handleException(ExceptionSupplier<T> exceptionSupplier) {
        return exceptionSupplier.handleException();
    }

    static void handleException(ExceptionRunnable exceptionRunnable) {
        try {
            exceptionRunnable.run();
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            handleException(exceptionRunnable);
        }
    }
}
