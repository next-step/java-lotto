package lotto.view;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_BUYING_MONEY = "구입금액을 입력해주세요.";
    private static final String INPUT_WINNER_LOTTO_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

    private InputView() {
        throw new AssertionError();
    }

    public static int inputBuyingMoney() {
        System.out.println(INPUT_BUYING_MONEY);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalStateException("잘못된 입력입니다. 올바른 구입 금액(숫자)를 입력해주세요.");
        }
    }

    public static String inputWinnerLottoNumbers() {
        System.out.println(INPUT_WINNER_LOTTO_NUMBERS);
        try {
            return scanner.nextLine();
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("당첨 번호 입력이 잘못되었습니다.");
        }
    }
}
