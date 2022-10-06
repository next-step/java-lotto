package lotto.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import static calculator.validator.InputValidator.isNumeric;


public class Input {
    private final static Scanner SCANNER = new Scanner(System.in);

    public int inputPrice() {
        System.out.println("구매하실 금액을 입력해주세요.(1장당 1000원)");
        String input = SCANNER.nextLine();
        if (isNumeric(input)) {
            return Integer.parseInt(input);
        }
        throw new InputMismatchException("입력하신 금액이 올바르지 않습니다.");
    }
}
