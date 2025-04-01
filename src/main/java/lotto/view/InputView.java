package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int inputManualLottoAmount() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<Integer> inputManualNumbers() {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        return Arrays.stream(inputString.split(", "))
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return inputManualNumbers();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
