package lotto.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import lotto.exception.WrongUserInputException;

public class InputView {

    private static final InputView inputView = new InputView();
    private final Scanner scanner = new Scanner(System.in);

    private static final String COMMA_DELIMITER = ",";

    private InputView() {
    }

    public int askMoneyAmount() {
        System.out.println("구입금액을 입력해주세요.");

        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new WrongUserInputException("잘못된 구입금액이 입력되었습니다.");
        }
    }

    public static InputView getInstance() {
        return inputView;
    }

    public Integer[] askWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return Arrays.stream(scanner.next().split(COMMA_DELIMITER))
            .map(String::trim)
            .map(Integer::parseInt)
            .toArray(Integer[]::new);
    }

    public void closeScanner() {
        scanner.close();
    }


}
