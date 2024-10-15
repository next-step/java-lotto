package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static Scanner SC = new Scanner(System.in);

    public static String getInput() {
        System.out.println("입력 해주세요");
        return SC.nextLine();
    }

    public static Integer getPaidMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(SC.nextLine());
        if (money < 1000) {
            throw new IllegalArgumentException("input money must be greater than or equal to 1000");
        }
        return money;
    }

    public static Integer getCountOfManualLottoNumbers() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(SC.nextLine());
    }

    public static List<List<Integer>> getManualLottoNumbers(int cnt) {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return IntStream.range(0, cnt)
                .mapToObj(it -> SC.nextLine())
                .map(it -> Arrays.stream(it.replaceAll(" ", "").split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

    public static Integer getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(SC.nextLine());
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String line = SC.nextLine();
        return Arrays.stream(line.replaceAll(" ", "").split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static String[] splitByEmptyString(String input) {
        if (input == null || input.replaceAll(" ", "").isEmpty()) {
            throw new IllegalArgumentException("input must not empty string");
        }
        if (!input.replaceAll(" ", "").replaceAll("[0-9]", "").matches("[+\\-*/\\s]+")) {
            throw new IllegalArgumentException("input must contain arithmetic characters");
        }
        return input.split(" ");
    }
}
