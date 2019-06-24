package camp.nextstep.edu.lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsoleInputView implements InputView {

    private static final String DELIMITER = ",";
    private static final String MESSAGE_FOR_INVESTMENT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_FOR_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

    @Override
    public int inputBudget() {
        System.out.println(MESSAGE_FOR_INVESTMENT);
        try (Scanner scanner = new Scanner(System.in)) {
            final String inputString = scanner.nextLine();
            return Integer.parseInt(inputString);
        }
    }

    @Override
    public List<Integer> inputWinningNumbers() {
        System.out.println(MESSAGE_FOR_WINNING_NUMBERS);
        try (Scanner scanner = new Scanner(System.in)) {
            final String inputString = scanner.nextLine();
            return Stream.of(inputString.split(DELIMITER))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
    }
}
