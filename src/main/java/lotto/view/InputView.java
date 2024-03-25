package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String DELIMITER = ", ";

    public static int inputLottoMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요");
        return scanner.nextInt();
    }

    public static List<Integer> inputWinningNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String inputString = scanner.nextLine();

        String[] splitInputString = inputString.split(DELIMITER);

        return Arrays.stream(splitInputString)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스볼을 입력해 주세요");
        return scanner.nextInt();
    }

}
