package lotto.view;

import java.util.Scanner;

public class InputVIew {

    private static final String QUESTION_START = "구입금액을 입력해주세요";
    private static final String WINNING_NUMBER_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";

    static Scanner scanner = new Scanner(System.in);

    public static int scanMoney() {
        printQuestionStart();
        return Integer.parseInt(scanString());
    }

    public static String scanWinningNumber(){
        printWinningNumberQuesion();
        return scanString();
    }

    private static void printWinningNumberQuesion() {
        System.out.println(WINNING_NUMBER_QUESTION);
    }

    private static String scanString() {
        return scanner.nextLine();
    }

    private static void printQuestionStart() {
        System.out.println(QUESTION_START);
    }
}
