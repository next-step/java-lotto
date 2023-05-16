package step2.view;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputCost() {
        System.out.println("구매할 금액을 입력해주세요.");
        return scanner.nextInt();
    }

}
