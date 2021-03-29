package lotto.view;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private Scanner scanner;

    public InputView(InputStream is) {
        this.scanner = new Scanner(is);
    }

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        return Integer.parseInt(this.scanner.nextLine());
    }

    public List<Integer> inputWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputString = this.scanner.nextLine();

        String[] inputNumbers = inputString.split(",");

        return Arrays.stream(inputNumbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
