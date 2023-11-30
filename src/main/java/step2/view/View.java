package step2.view;

public interface View {
    default void nextLine() {
        System.out.println();
    }
}
