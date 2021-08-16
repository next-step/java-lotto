package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> readNumbers() {
        String raw = null;
        while (raw == null || raw.isEmpty()) {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            raw = scanner.nextLine();
        }

        return Arrays.stream(raw.split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
