package step2_bak.View;

import step2_bak.Winning;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class InputView {
    private static final String AMOUNT = "구입금액을 입력해 주세요.";
    private static final String AMOUNT_CONFIRM_POSTFIX = "개를 구매했습니다.";
    private static final String WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static Scanner scanner = new Scanner(System.in);

    public static int buyTickets() {
        System.out.println(AMOUNT);
        int amount = scanner.nextInt();
        if ( amount % 1000 != 0 || amount / 1000 < 1 ) {
            throw new IllegalArgumentException("로또는 1000뤈단위로 구매할 수 있습니다.");
        }
        int ticketAmount = amount / 1000;
        System.out.println(ticketAmount + AMOUNT_CONFIRM_POSTFIX);
        return ticketAmount;
    }

    public static Winning winningNumber() {
        scanner.nextLine();
        System.out.println(WINNING_NUMBER);
        String inputNumbers = scanner.nextLine();
        Set<Integer> winningNumbers = Arrays.stream(inputNumbers.split(","))
                .map(num -> Integer.parseInt(num.trim()))
                .collect(toSet());

        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("입력된 로도번호가 6개가 아닙니다.");
        }

        if (winningNumbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("로또번호는 1 ~ 45 사이의 숫자입니다.");
        }
        return new Winning(winningNumbers);
    }
}
