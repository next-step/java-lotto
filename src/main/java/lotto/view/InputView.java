package lotto.view;

import lotto.view.printable.QuestionPrintable;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    private static void printQuestion(String question) {
        new QuestionPrintable(question).print();
    }

    public static int askPurchaseMoney() {
        printQuestion("구입금액을 입력해 주세요.");
        String money = scanner.nextLine();
        Validator.validateNumber(money);
        return Integer.parseInt(money);
    }

    private static String askLotto() {
        String lotto = scanner.nextLine();
        Validator.validateNpe(lotto);
        return lotto;
    }

    public static String askWinningLotto() {
        printQuestion("지난 주 당첨 번호를 입력해 주세요.");
        return askLotto();
    }

    public static int askBonusBall() {
        printQuestion("보너스 볼을 입력해 주세요.");
        String bonus = scanner.nextLine();
        Validator.validateNumber(bonus);
        return Integer.parseInt(bonus);
    }

}
