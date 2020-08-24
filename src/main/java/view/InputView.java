package view;

import domain.Number;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);

    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Number> getWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        String str = scanner.nextLine();
        return getWinningListFromString(str);
    }

    public static Number getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String s = scanner.nextLine();
        return new Number(Integer.parseInt(s));
    }

    private static List<Number> getWinningListFromString(String winningNumberStr) {
        return Arrays.stream(winningNumberStr.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(Number::new)
                .collect(Collectors.toList());
    }
}