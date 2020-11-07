package lotto.view;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String PHRASE_FOR_MONEY = "구입금액을 입력해 주세요.";
    private static final String PHRASE_FOR_LAST_LOTTO_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    private final Scanner scanner;
    private final PrintWriter output;

    public InputView(Scanner scanner, PrintWriter output) {
        this.scanner = scanner;
        this.output = output;
    }

    public int getMoney() {

        output.println(PHRASE_FOR_MONEY);
        return Integer.parseInt(scanner.nextLine());
    }

    public List<Integer> getLastLottoNumbers() {
        output.println(PHRASE_FOR_LAST_LOTTO_NUMBER);
        return Arrays.stream(scanner.nextLine().split(","))
                .map(input -> Integer.parseInt(input.trim()))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));

    }
}
