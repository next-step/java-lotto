package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class InputView {

    private static final String SEPARATOR = ",";
    private static final int INIT = 0;

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public int inputLottoCountToPurchaseManually() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public List<String> inputNumberOfLottoToPurchaseManually(int manualLottoCount) {
        List<String> manuallyLottos = new ArrayList<>();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = INIT; i < manualLottoCount; i++) {
            manuallyLottos.add(scanner.next());
        }

        return manuallyLottos;
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return splitNumbers(scanner.next());
    }

    private List<Integer> splitNumbers(final String input) {
        String[] dividedNumbers = input.trim().split(SEPARATOR);
        return Arrays.stream(dividedNumbers).map(Integer::parseInt).collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

}
