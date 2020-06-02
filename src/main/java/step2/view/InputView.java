package step2.view;

import step2.model.*;
import step2.util.WinningNumberSplitter;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static MoneyAmount getPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        int useAmount = Integer.parseInt(scanner.nextLine());

        return MoneyAmount.create(Money.valueOf(useAmount));
    }

    public static WinningNumbers getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumber = scanner.nextLine();

        return WinningNumberSplitter.split(winningNumber).stream()
                .map(LottoNumber::valueOf)
                .collect(collectingAndThen(toList(), WinningNumbers::create));
    }
}
