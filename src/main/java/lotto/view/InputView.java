package lotto.view;

import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    static private Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputMoney() {
        System.out.println("구입금액을 입력해주세요");
        return Integer.parseInt(scanner.nextLine());
    }

    public static Lotto inputWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumberStr = scanner.nextLine();
        String[] winningNumbers = winningNumberStr.split(", ");
        return new Lotto(Arrays.stream(winningNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }
}

