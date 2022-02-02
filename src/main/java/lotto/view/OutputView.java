package lotto.view;

public class OutputView {

    private static final String MANAGER_LOG = "%d개를 구매했습니다.";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printPurchaseAmount(int ticketCount) {
        OutputView.printMessage(String.format(MANAGER_LOG, ticketCount));

    }
}
