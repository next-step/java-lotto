package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public static int requestPrice() {
        System.out.println("구입급액을 입력해주세요.");
        int num = Integer.parseInt(scanner.nextLine().trim());
        return num;
    }

    public static List<Integer> requestNums() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winNums = scanner.nextLine();

        return Arrays.stream(winNums.split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public static Integer requestBonusNum() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int num = Integer.parseInt(scanner.nextLine().trim());
        return num;
    }
}
