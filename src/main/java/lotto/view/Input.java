package lotto.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import static validator.InputValidator.isNumeric;


public class Input {
    private final static Scanner SCANNER = new Scanner(System.in);

    public int price() {
        System.out.println("구매하실 금액을 입력해주세요.(1장당 1000원 / 최대 100장 구매 가능)");
        String input = SCANNER.nextLine();
        if (isNumeric(input)) {
            return Integer.parseInt(input);
        }
        throw new InputMismatchException("입력하신 금액이 올바르지 않습니다.");
    }
}
