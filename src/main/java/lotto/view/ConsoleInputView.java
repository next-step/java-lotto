package lotto.view;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleInputView {
    private ConsoleInputView() {
    }

    public static int inputMoney(Scanner scanner) {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static Lotto inputWinnerNumbers(Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winnerNumbersString = scanner.nextLine();

        List<Integer> winnerNumbers = Arrays.stream(winnerNumbersString.split(","))
                .map(number -> Integer.parseInt(number.trim()))
                .collect(Collectors.toList());

        return new Lotto(winnerNumbers);
    }
}
