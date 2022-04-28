package lotto.view;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class WinnerInputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_WINNER_LOTTO_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private WinnerInputView() {
        throw new AssertionError();
    }

    public static String inputWinnerLottoNumbers() {
        System.out.println(LINE_SEPARATOR + INPUT_WINNER_LOTTO_NUMBERS);
        try {
            return SCANNER.nextLine();
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("당첨 번호 입력이 잘못되었습니다.");
        }
    }
}
