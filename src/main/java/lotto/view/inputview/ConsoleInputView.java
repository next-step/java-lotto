package lotto.view.inputview;

import lotto.Lotto;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ConsoleInputView implements InputView {
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

        Set<Integer> winningNumbers = Arrays.stream(winningNumbersInput.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toCollection(TreeSet::new));

        if (winningNumbers.size() != Lotto.VALID_NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }

        return winningNumbers;
    }
}
