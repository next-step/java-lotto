package camp.nextstep.edu.lotto.view.console;

import camp.nextstep.edu.lotto.view.InputView;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsoleInputView implements InputView {

    private static final String DELIMITER = ",";
    private static final String MESSAGE_FOR_INVESTMENT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_FOR_WINNING_NUMBERS = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String MESSAGE_FOR_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    @Override
    public int inputInvestment() {
        System.out.println(MESSAGE_FOR_INVESTMENT);
        final String inputString = SCANNER.nextLine();
        return Integer.parseInt(inputString);
    }

    @Override
    public Set<Integer> inputWinningNumbers() {
        System.out.println(MESSAGE_FOR_WINNING_NUMBERS);
        final String inputString = SCANNER.nextLine();
        return Stream.of(inputString.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    @Override
    public int inputBonusNumber() {
        System.out.println(MESSAGE_FOR_BONUS_NUMBER);
        final String inputString = SCANNER.nextLine();
        return Integer.parseInt(inputString);
    }
}
