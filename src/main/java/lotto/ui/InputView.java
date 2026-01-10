package lotto.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public int readManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public List<Lotto> readManualLottos(int manualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        // 예: 1,2,3,4,5,6 (manualCount줄)
        return java.util.stream.IntStream.range(0, manualCount)
            .mapToObj(i -> new Lotto(parseNumbers(scanner.nextLine().trim())))
            .collect(Collectors.toList());
    }

    public List<Integer> readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return parseNumbers(scanner.nextLine().trim());
    }

    public int readBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    private List<Integer> parseNumbers(String line) {
        return Arrays.stream(line.split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
}
