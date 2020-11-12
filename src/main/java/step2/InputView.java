package step2;

import step2.domain.LotteryNumber;
import step2.domain.Money;

import java.util.Arrays;
import java.util.Scanner;

class InputView {
    public Money requestMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return Money.of(scanner.nextInt());
    }

    public LotteryNumber requestLastWeekLotteryNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Integer[] lastWeekLotteryNumber = splitAndConvertToIntArray(line);
        return LotteryNumber.of(lastWeekLotteryNumber);
    }

    public static Integer[] splitAndConvertToIntArray(String line) {
        return Arrays.stream(line.split(",")) //
                .map(String::trim) //
                .map(Integer::valueOf) //
                .toArray(Integer[]::new);
    }
}
