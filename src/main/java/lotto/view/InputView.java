package lotto.view;

import util.Parser;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int createBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Integer> createWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputValue = scanner.next();
        return Parser.convertToInteger(inputValue);
    }
}
