package study.lotto.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final String WINNING_NUMBER_DELIMITER = ",";
    private static final String BLANK_STRING = " ";

    private final Scanner scanner = new Scanner(System.in);

    public int scanTotalPrice() {
        int totalPrice;

        System.out.println("구매 금액을 입력해 주세요.");

        try {
            totalPrice = scanner.nextInt();
            scanner.nextLine();     // 버퍼에서 개행문자 제거
        } catch(InputMismatchException e) {
            scanner.nextLine();     // 버퍼에서 개행문자 제거
            System.out.println("숫자만 입력 가능합니다. 다시 입력해주세요.");

            return scanTotalPrice();
        }

        return totalPrice;
    }

    public String[] scanWinningNumbers() {
        String answer;

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        try {
            answer = scanner.nextLine();
            answer = answer.replaceAll(BLANK_STRING, "");
        } catch(InputMismatchException e) {
            scanner.nextLine();     // 버퍼에서 개행문자 제거
            System.out.println("문자만 입력 가능합니다. 다시 입력해주세요.");

            return scanWinningNumbers();
        }

        return answer.split(WINNING_NUMBER_DELIMITER);
    }
}
