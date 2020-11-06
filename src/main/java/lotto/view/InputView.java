package lotto.view;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner;
    private final PrintWriter output;

    public InputView(Scanner scanner, PrintWriter output) {
        this.scanner = scanner;
        this.output = output;
    }

    public int getMoney() {
        output.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public List<Integer> getLastLottoNumbers() {
        output.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(scanner.nextLine().split(","))
                .map(input -> Integer.parseInt(input.trim()))
                .collect(Collectors.toList());

    }
}
