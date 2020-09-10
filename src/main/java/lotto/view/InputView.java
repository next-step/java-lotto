package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toCollection;

public class InputView {
    private static final String DELIMITER = ",";
    private static Scanner scan = new Scanner(System.in);

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력하세요.");

        return scan.nextInt();
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        Scanner scan = new Scanner(System.in);
        String[] inputStr = scan.nextLine().split(DELIMITER);

        return Arrays.stream(inputStr)
                     .map(input -> Integer.parseInt(input.trim()))
                     .collect(toCollection(ArrayList::new));
    }
}
