package step2.view;

import step2.util.Constants;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner;

    public void init() {
        scanner = new Scanner(System.in);
    }

    /**
     * 사용자 입력 메시지를 출력하는 메소드
     */
    public void showInputMessage() {
        System.out.println(Constants.INPUT_MONEY_MESSAGE);
    }

    /**
     * 로또 구입 금액을 입력받는 메소드
     * @return 구입 금액
     */
    public int getPurchaseAmount() {
        return scanner.nextInt();
    }

    /**
     * 사용자 입력 메시지를 출력하는 메소드
     */
    public void showInputWinningMessage() {
        System.out.println();
        System.out.println(Constants.INPUT_WINNING_NUMBERS_MSG);
    }

    /**
     * 당첨 번호를 입력받아 문자열 배열로 리턴하는 메소드
     * @return 사용자에게 입력받은 당첨 번호 배열
     */
    public String[] getWinningNumbers() {
        return scanner.nextLine().split(Constants.COMMA_DELIMITER);
    }
}
