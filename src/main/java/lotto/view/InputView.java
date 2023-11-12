package lotto.view;

import lotto.domain.ManualCount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String COMMA_BLANK = ", ";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String BUYING_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MANUAL_BUYING_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int inputAmount() {
        System.out.println(BUYING_AMOUNT);
        int input = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        return input;
    }

    public List<Integer> winnerNumber() {
        System.out.println(WINNING_NUMBER);
        String input = scanner.nextLine();

        List<Integer> numbers = new ArrayList<>();
        for (String number : input.split(COMMA_BLANK)) {
            numbers.add(Integer.valueOf(number));
        }

        return numbers;
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);

        return scanner.nextInt();
    }

    public int inputManualCount() {
        System.out.println(MANUAL_BUYING_COUNT);
        int input = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        return input;
    }

    public List<String> inputManualNumbers(ManualCount manualCount) {
        List<String> list = new ArrayList<>();
        System.out.println(MANUAL_NUMBER);
        for (int i = 0; i < manualCount.count(); i++) {
            list.add(scanner.nextLine());
        }
        System.out.println();

        return list;
    }
}
