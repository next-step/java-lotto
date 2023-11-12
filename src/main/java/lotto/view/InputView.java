package lotto.view;

import lotto.domain.ManualCount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String COMMA_BLANK = ", ";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int input = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        return input;
    }

    public List<Integer> winnerNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
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
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int input = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        return input;
    }

    public List<String> inputManualNumbers(ManualCount manualCount) {
        List<String> list = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualCount.count(); i++) {
            list.add(scanner.nextLine());
        }
        System.out.println();

        return list;
    }
}
