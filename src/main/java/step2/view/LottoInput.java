package step2.view;

import step2.model.LottoNumber;

import java.util.Scanner;

public class LottoInput {

    private static final String INPUT_MENT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    public static int inputGameMoney() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(INPUT_MENT);
        int inputMoney = scanner.nextInt();

        return inputMoney;
    }

    public static String inputWinnerNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(INPUT_WIN_NUMBER);
        String inputWinnerNumbers = scanner.nextLine();

        return inputWinnerNumbers;
    }
}