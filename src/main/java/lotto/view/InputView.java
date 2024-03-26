package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int scanAmount(){
        System.out.println("구입 금액을 입력해 주세요.");
        int amount = scanner.nextInt();
        scanner.nextLine();
        return amount;
    }

    public static List<Integer> scanWinningNumbers(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String text = scanner.nextLine();
        return convertStringToIntList(text);
    }

    private static List<Integer> convertStringToIntList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
