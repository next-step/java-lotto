package lotto.view;

import java.util.Scanner;
import lotto.domain.winning.WinningNumbers;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static WinningNumbers getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        String[] numbers = input.split(", ");

        System.out.println("보너스 볼을 입력해 주세요.");
        return new WinningNumbers(numbers, scanner.nextLine());
    }
}
