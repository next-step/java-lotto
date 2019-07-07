package step2;

import java.util.Scanner;

public class InputView {

    private Scanner scan = new Scanner(System.in);

    public int inputCash() {
        System.out.println("구입금액을 입력해 주세요.");
        String cash = scan.nextLine();

        InputValidationCheck.checkEmpty(cash);
        InputValidationCheck.checkCash(cash);

        return Integer.parseInt(cash) / Lotto.LOTTO_PRICE;
    }

    public String[] inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] inputWinningNumbers = scan.nextLine().split(",");

        InputValidationCheck.checkWinningNumbers(inputWinningNumbers);
        InputValidationCheck.checkWinningNumberRange(inputWinningNumbers);

        return inputWinningNumbers;
    }
}
