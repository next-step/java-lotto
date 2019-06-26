package step2.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static long inputMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextLong();
    }

    public static List<Integer> inputWinningLottoNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        final String numbersLine = scanner.nextLine();

        return Arrays.stream(numbersLine.split(", "))
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
