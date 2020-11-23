package step2.view;

public class ResultView {
    private static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printPurchasePrice() {
        printMessage("구입금액을 입력해 주세요.");
    }
}
