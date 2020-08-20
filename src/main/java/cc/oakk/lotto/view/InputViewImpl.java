package cc.oakk.lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputViewImpl implements InputView {
    private static final String NUMBER_DELIMITER = ", ";
    private final Scanner scanner;

    public InputViewImpl() {
        this.scanner = new Scanner(System.in);
    }

    public InputViewImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public int readMoney() {
        return scanner.nextInt();
    }

    @Override
    public List<Integer> readWinningNumbers() {
        String input = scanner.useDelimiter("\n").next();

        return Arrays.stream(input.split(NUMBER_DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
