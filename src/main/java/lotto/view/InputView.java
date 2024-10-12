package lotto.view;

import java.util.Scanner;

import lotto.domain.WinNumber;

public class InputView {

    public static final String DELIMITER = ", ";

    public static int inputAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static WinNumber inputWinnerNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputNumber = scanner.nextLine();

        String[] split = inputNumber.split(DELIMITER);

        return new WinNumber(split);
    }
}
