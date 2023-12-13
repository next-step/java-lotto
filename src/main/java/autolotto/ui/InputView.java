package autolotto.ui;

import autolotto.domain.Lotto;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final String SPLIT_PATTERN = ",";
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static int buyAmt() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(checkNllOrBlank(scanner.nextLine()));
    }

    private static String checkNllOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값을 입력하지 않았습니다.");
        }
        return input;
    }

    public static List<Integer> lastWeekWinNumber() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = inputNumbers();
        checkDuplicateNumber(winningNumbers);
        return winningNumbers;
    }

    private static void checkDuplicateNumber(List<Integer> winningNumbers) {
        Set<Integer> uniqueNumber = winningNumbers.stream().collect(Collectors.toSet());
        if (winningNumbers.size() != uniqueNumber.size()) {
            throw new IllegalArgumentException("당첨번호 중 중복된 숫자가 존재합니다. 다시 입력해 주세요.");
        }
    }

    public static int bonusNumber() {
        System.out.println("\n보너스 볼을 입력해 주세요.");
        return Integer.parseInt(checkNllOrBlank(scanner.nextLine()));
    }

    public static int manualLottoCount(int ticketsCount) {
        int manualLottoCount = inputManualLottoCount();
        if (manualLottoCount > ticketsCount) {
            throw new IllegalArgumentException("구매한 금액보다 많은 수를 입력하였습니다.");
        }
        if (manualLottoCount > 0) {
            printInputMessage();
        }
        return manualLottoCount;
    }

    private static int inputManualLottoCount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoCount = Integer.parseInt(checkNllOrBlank(scanner.nextLine()));
        return manualLottoCount;
    }

    public static List<Lotto> getManualNumbers(int manualLottoCount) {
        List<Lotto> manualNumbers = IntStream.range(0, manualLottoCount)
                .mapToObj(i -> new Lotto(inputNumbers()))
                .collect(Collectors.toList());
        return manualNumbers;
    }

    private static List<Integer> inputNumbers() {
        return Arrays.stream(checkNllOrBlank(scanner.nextLine()).split(SPLIT_PATTERN))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void printInputMessage() {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
    }
}
