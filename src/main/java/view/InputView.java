package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);

    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> getWinningNumberStr() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        String str = scanner.nextLine();
        return getWinningListFromString(str);
    }
    private static List<Integer> getWinningListFromString(String winningNumberStr) {
        return Arrays.stream(winningNumberStr.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}