package lotto.view.inputview;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ConsoleInputView implements InputView {
    private static final String DELIMITER = ",";

    private final Scanner scanner;

    public ConsoleInputView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int getAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    @Override
    public Set<Integer> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbersInput = scanner.next();

        return Arrays.stream(winningNumbersInput.split(DELIMITER))
                .map(Integer::valueOf)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    @Override
    public int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
