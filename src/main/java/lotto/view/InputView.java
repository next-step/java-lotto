package lotto.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public Long inputPurchasePrice() {
        ResultView.printPurchasePriceInputCommand();
        return Long.parseLong(nextLine());
    }

    public String inputWinningLottoNumbers() {
        ResultView.printWinningLottoNumberInputCommand();
        return nextLine();
    }

    private String nextLine() {
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }

}
