package autolotto.ui;

import autolotto.domain.Lotto;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        return winningNumbers;
    }

    public static int bonusNumber() {
        System.out.println("\n보너스 볼을 입력해 주세요.");
        return Integer.parseInt(checkNllOrBlank(scanner.nextLine()));
    }

    public static List<Lotto> manualLotto() {
        int manualLottoCount = getManualLottoCount();
        if(manualLottoCount == 0){
            return null;
        }
        return Stream.generate(() -> new Lotto(inputNumbers()))
                .collect(Collectors.toList());
    }

    private static int getManualLottoCount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        int manualLottoCount = Integer.parseInt(checkNllOrBlank(scanner.nextLine()));
        return manualLottoCount;
    }

    private static List<Lotto> manual(int manualLottoCount) {
        return IntStream.range(0, manualLottoCount)
                .mapToObj(i -> new Lotto(inputNumbers()))
                .collect(Collectors.toList());
    }

    private static List<Integer> inputNumbers() {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        return Arrays.stream(checkNllOrBlank(scanner.nextLine()).split(SPLIT_PATTERN))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
