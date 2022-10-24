package step4.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static int inputPrice() {
        OutputView.printPriceNotification();
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<Integer> inputWinningNumbers() {
        OutputView.printWinningNumberNotification();
        Scanner scanner = new Scanner(System.in);
        return Arrays.stream(scanner.nextLine().split(", "))
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
    }

    public static int inputBonusBall() {
        OutputView.printBonusBallNotification();
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
