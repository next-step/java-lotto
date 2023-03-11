package lotto.view;

import lotto.domain.Money;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    public static Money inputBuyPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);

        return new Money(Integer.parseInt(scanner.nextLine()));
    }

    public static Set<Integer> inputLastWeekWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String inputWinningNumbers = scanner.nextLine();
        String[] splitWinningNumbers = inputWinningNumbers.replaceAll(" ", "").split(",");
        return Arrays.stream(splitWinningNumbers).map(Integer::parseInt).collect(Collectors.toSet());
    }

    public static int inputLastWeekBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

}
