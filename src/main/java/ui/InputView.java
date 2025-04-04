package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int inputManualGameCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<List<Integer>> inputPickedNumbers(int manualGameCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        var result = new ArrayList<List<Integer>>();

        for (int i = 0; i < manualGameCount; i++) {
            String pickedNumbers = scanner.nextLine();

            result.add(Stream.of(pickedNumbers.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toUnmodifiableList()));
        }

        return result;
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String winningNumbers = scanner.nextLine();

        return Stream.of(winningNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
