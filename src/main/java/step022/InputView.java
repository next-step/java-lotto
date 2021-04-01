package step022;

import java.util.Scanner;

import static step022.LottoConfig.*;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int inputMoney() {
        System.out.println(INPUT_MONEY);
        return scanner.nextInt();
    }
}
