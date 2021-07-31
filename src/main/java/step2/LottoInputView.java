package step2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputView {
    public int getBudgetWithPrompt() {
        System.out.println("구입금액을 입력해 주세요.");

        try (Scanner scanner = new Scanner(System.in)) {
            return scanner.nextInt();
        }
    }

    public List<Integer> getLastDrawNumbersWithPrompt() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        try (Scanner scanner = new Scanner(System.in)) {
            String lastDrawNumbersString = scanner.nextLine();

            return parseLastDrawNumbersString(lastDrawNumbersString);
        }
    }

    private List<Integer> parseLastDrawNumbersString(String lastDrawResultString) {
        return Arrays.stream(lastDrawResultString.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
