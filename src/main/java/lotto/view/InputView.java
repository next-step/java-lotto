package lotto.view;

import lotto.domain.BonusBall;
import lotto.domain.WinningNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(scanner.nextLine());
        System.out.println(money / 1000 + "개를 구매했습니다.");
        return money;
    }

    public static WinningNumber inputWinningNumber() {
        System.out.println("지난주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        String[] split = input.split(",");
        List<Integer> winningNumber = Arrays.stream(split)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("보너스 볼을 입력해 주세요.");
        input = scanner.nextLine();

        return WinningNumber.from(winningNumber, BonusBall.from(input));
    }
}
