package lotto.view;

import java.util.Scanner;

public class InputView {

    public static final String SPLIT_CRITERIA = ", |,";
    public static final String GUIDELINE_TEXT_TO_GET_PRICE = "구입금액을 입력해 주세요.";
    public static final String GUIDELINE_TEXT_TO_GET_WINNING_NUM = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String GUIDELINE_TEXT_TO_GET_BONUS_NUM = "보너스 볼을 입력해 주세요.";

    private InputView() {
        throw new AssertionError();
    }

    public static int getLottoPrice() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(GUIDELINE_TEXT_TO_GET_PRICE);
        int paidMoney = Integer.parseInt(scanner.nextLine());

        return paidMoney;
    }

    public static String[] getWinningNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(GUIDELINE_TEXT_TO_GET_WINNING_NUM);
        String[] winningNumbers = scanner.nextLine().split(SPLIT_CRITERIA);

        return winningNumbers;
    }

    public static int getBonusNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(GUIDELINE_TEXT_TO_GET_BONUS_NUM);
        int bonusNumber = Integer.parseInt(scanner.nextLine());

        return bonusNumber;
    }

}
