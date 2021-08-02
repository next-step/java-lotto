package step2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputView {

    public static int getBudgetWithPrompt(Scanner scanner) {
        System.out.println("구입금액을 입력해 주세요.");

        return scanner.nextInt();
    }

    public static List<Integer> getLastDrawNumbersWithPrompt(Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();     // 엔터값 제거

        return parseLastDrawNumbersString(scanner.nextLine());
    }

    private static List<Integer> parseLastDrawNumbersString(String lastDrawResultString) {
        return Arrays.stream(lastDrawResultString.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
