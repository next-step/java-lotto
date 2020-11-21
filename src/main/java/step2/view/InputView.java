package step2.view;

import step2.utils.Sets;

import java.util.*;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int requestMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return nextInt();
    }

    public Set<Set<Integer>> requestManualSelectionNumbers() {
        int manualSelectionCount = requestManualSelectionCount();

        if (manualSelectionCount == 0) {
            return Collections.emptySet();
        }

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Set<Set<Integer>> lotteryNumbers = new HashSet<>();
        for (int i = 0; i < manualSelectionCount; i++) {
            String line = nextLine();
            lotteryNumbers.add(Sets.of(splitAndConvertToIntArray(line)));
        }

        return lotteryNumbers;
    }

    protected int requestManualSelectionCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return nextInt();
    }

    public Integer[] requestLastWeekLotteryNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String line = nextLine();
        return splitAndConvertToIntArray(line);
    }

    public Integer requestBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return nextInt();
    }

    public static Integer[] splitAndConvertToIntArray(String line) {
        return Arrays.stream(line.split(",")) //
                .map(String::trim) //
                .map(Integer::valueOf) //
                .toArray(Integer[]::new);
    }

    private String nextLine() {
        String line = scanner.nextLine();
        while (line.isEmpty()) {
            line = scanner.nextLine();
        }
        return line;
    }

    private int nextInt() {
        String line = scanner.nextLine();
        while (line.isEmpty()) {
            line = scanner.nextLine();
        }
        return Integer.parseInt(line);
    }
}
