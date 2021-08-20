package lotto.view;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int requestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int requestManualTicket() {
        System.out.println();
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Set<Integer>> requestManualNumbers(int manualTicket) {
        System.out.println();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Set<Integer>> manualLottoSet = new ArrayList<>();
        IntStream.range(0, manualTicket)
                .forEach(i -> manualLottoSet.add(getLottoNumberSet()));
        return manualLottoSet;
    }

    public static Set<Integer> requestWinnerNumbers() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        return getLottoNumberSet();
    }

    private static Set<Integer> getLottoNumberSet() {
        return Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
    }

    public static int requestBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }
}
