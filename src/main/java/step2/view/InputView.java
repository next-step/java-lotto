package step2.view;

import step2.domain.LotteryNumber;
import step2.domain.Money;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public Money requestMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Money.of(scanner.nextInt());
    }

    public Set<LotteryNumber> requestManualSelectionNumbers() {
        int manualSelectionCount = requestManualSelectionCount();

        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Set<LotteryNumber> lotteryNumbers = new HashSet<>();
        for (int i = 0; i < manualSelectionCount; i++) {
            String line = scanner.nextLine();
            lotteryNumbers.add(LotteryNumber.of(splitAndConvertToIntArray(line)));
        }

        return lotteryNumbers;
    }

    protected int requestManualSelectionCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public LotteryNumber requestLastWeekLotteryNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String line = scanner.nextLine();
        Integer[] lastWeekLotteryNumber = splitAndConvertToIntArray(line);
        return LotteryNumber.of(lastWeekLotteryNumber);
    }

    public Integer requestBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static Integer[] splitAndConvertToIntArray(String line) {
        return Arrays.stream(line.split(",")) //
                .map(String::trim) //
                .map(Integer::valueOf) //
                .toArray(Integer[]::new);
    }
}
