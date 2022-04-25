package calculator.view;

public class ResultView {

    private ResultView() {
    }

    public static <T> void print(T t) {
        System.out.println(t.toString());
    }
}
