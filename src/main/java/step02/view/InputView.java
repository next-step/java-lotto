package step02.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private InputView() {
    }

    public static Scanner scanner() {
        return new Scanner(System.in);
    }

    public static int initPurchasePrice() {
        PrintView.printInitPurchasePricePhrase();
        return scanner().nextInt();
    }

    public static List<Integer> initLastWeekWinningNumbers() {
        PrintView.printInitLastWeekWinningNumbers();
        String init = scanner().next();
        String[] split = init.split(",");
        return Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static int initBonusBallNumber() {
        PrintView.printInitBonusBallNumberPhrase();
        return scanner().nextInt();
    }

    public static int initManualLottoCount() {
        PrintView.printInitManualLottoCount();
        return scanner().nextInt();
    }

    public static List<String> initManualLotto(int count) {
        PrintView.printInitManualLotto();

        return IntStream.range(0, count)
            .mapToObj(i -> scanner().nextLine())
            .collect(Collectors.toList());
    }
}
