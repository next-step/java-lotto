package lotto.view;

import lotto.model.Lotto;
import lotto.model.Money;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(scanner.nextInt());
    }

    public static Lotto inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = Arrays.stream(scanner.next().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());
        return new Lotto(winningNumbers);
    }
}
