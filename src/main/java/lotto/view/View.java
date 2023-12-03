package lotto.view;

public interface View {

    default void nextLine() {
        System.out.println();
    }

    default void print(String format, Object... args) {
        System.out.printf(format, args);
    }
}
