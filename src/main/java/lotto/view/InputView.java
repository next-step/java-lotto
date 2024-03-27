package lotto.view;

import lotto.domain.Cash;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static Cash generateCash() {
        return new Cash(insertNumber());
    }

    public static List<Integer> generateLatestWinningNumbers() {
        String str = insertValues();
        return Arrays.stream(str.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int insertNumber() {
        return new Scanner(System.in).nextInt();
    }

    private static String insertValues() {
        return new Scanner(System.in).nextLine();
    }
}
