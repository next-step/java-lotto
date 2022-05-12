package lotto.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_BUYING_MONEY = "구입금액을 입력해주세요.";
    private static final String INPUT_WINNER_LOTTO_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_LOTTO_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    private InputView() {
        throw new AssertionError();
    }

    public static int askBuyingMoney() {
        System.out.println(INPUT_BUYING_MONEY);
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (InputMismatchException e) {
            throw new IllegalStateException("잘못된 입력입니다. 올바른 구입 금액(숫자)를 입력해주세요.");
        }
    }

    public static String askWinnerLottoNumbers() {
        System.out.println(LINE_SEPARATOR + INPUT_WINNER_LOTTO_NUMBERS);
        try {
            return SCANNER.nextLine();
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("당첨 번호 입력이 잘못되었습니다.");
        }
    }

    public static Integer askBonusLottoNumber() {
        System.out.println(LINE_SEPARATOR + INPUT_BONUS_LOTTO_NUMBER);
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (InputMismatchException e) {
            throw new IllegalStateException("잘못된 입력입니다. 올바른 로또 당첨 번호(숫자)를 입력해주세요.");
        }
    }

    public static Integer askManualLottoCount() {
        System.out.println(LINE_SEPARATOR + INPUT_MANUAL_LOTTO_COUNT);
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (InputMismatchException e) {
            throw new IllegalStateException("잘못된 입력입니다. 올바른 수동 구매 개수를 입력해주세요.");
        }
    }

    public static List<String> askManualLottoNumbers(int count) {
        System.out.println(LINE_SEPARATOR + INPUT_MANUAL_LOTTO_NUMBERS);
        try {
            return Stream.generate(() -> SCANNER.nextLine())
                    .limit(count)
                    .collect(Collectors.toList());
        } catch (NoSuchElementException e) {
            throw new IllegalStateException("잘못된 입력입니다. 올바른 수동 구매 로또 번호를 입력해주세요.");
        }
    }
}
