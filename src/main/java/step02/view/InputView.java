package step02.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int initPurchasePrice() {
        PrintView.printInitPurchasePricePhrase();
        return SCANNER.nextInt();
    }

    public static List<Integer> initLastWeekWinningNumbers() {
        PrintView.printInitLastWeekWinningNumbers();
        String init = SCANNER.next();
        String[] split = init.split(",");
        return Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
    }
}
