package lotto;

import java.util.Scanner;

public class InputView {

    private Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public int insertLottoPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return inputScannerInt();
    }

    private int inputScannerInt() {
        return scanner.nextInt();
    }
}
