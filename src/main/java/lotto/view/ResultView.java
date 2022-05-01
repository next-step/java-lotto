package lotto.view;

public class ResultView {

    private ResultView() {
    }

    public static void print(String message) {
        System.out.println(message);
    }

    public static void printResult(int index, int prize, int resultCount) {
        print(String.format("%s개 일치 (%s원)- %s개", index, prize, resultCount));
    }
}
