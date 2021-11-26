package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InsertView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String COMMA = ",";

    private InsertView() {}

    public static String printInputIntro() {
        System.out.println("구매금액을 입력해 주세요");

        return scanner.nextLine();
    }

    public static List<Integer> printInputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        System.out.println();
        return setWinningNumbers(input);
    }

    private static List<Integer> setWinningNumbers(String input) {
        return Arrays.stream(input.split(COMMA))
                .map(s -> Integer.valueOf(s.trim()))
                .collect(Collectors.toList());
    }

}
