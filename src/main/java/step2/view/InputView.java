package step2.view;

import step2.domain.Lottery;
import step2.domain.Number;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static int start() {
        System.out.println("구입금액을 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt() / 1000;
        System.out.println(String.format("%d개를 구매했습니다.", input));

        return input;
    }

    public static Lottery inputLotteryNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        Scanner scanner = new Scanner(System.in);
        List<Number> numbers = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            numbers.add(new Number(scanner.nextInt()));
        }

        return new Lottery(numbers);
    }
}
