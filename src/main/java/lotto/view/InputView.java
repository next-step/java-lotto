package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ", ";

    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int getManualLottoCount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<List<Integer>> getManualLottoList(int manualLottoCount) {
        if (manualLottoCount == 0) {
            return new ArrayList<>();
        }

        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        return IntStream.range(0, manualLottoCount)
                .mapToObj(i -> getNumbers())
                .collect(Collectors.toList());
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return getNumbers();
    }

    public static int getBonusNumber() {
        System.out.println("\n보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    private static List<Integer> getNumbers() {
        return Arrays.stream(scanner.nextLine().split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
