package lotto.view;

import lotto.model.Lotto;
import lotto.model.Money;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(scanner.nextInt());
    }

    public static Lotto inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Set<Integer> winningNumbers = Arrays.stream(scanner.next().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        return new Lotto(winningNumbers);
    }
}
