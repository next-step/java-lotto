package lotto.view;

import lotto.domain.WinningNumber;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(scanner.nextLine());
        System.out.println(money / 1000 + "개를 구매했습니다.");
        return money;
    }

    public WinningNumber inputWinningNumber() {
        System.out.println("지난주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        String[] split = input.split(",");
        return Arrays.stream(split)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.collectingAndThen(Collectors.toList(), WinningNumber::from));
    }
}
