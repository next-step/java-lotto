package lotto.view;

import lotto.validator.InputValidator;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private final InputValidator inputValidator = new InputValidator();

    public int getPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");

        String inputPrice = scanner.nextLine();
        inputValidator.validate(inputPrice);

        return Integer.parseInt(inputPrice);
    }

    public String getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return scanner.nextLine();
    }

}
