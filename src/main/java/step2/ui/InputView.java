package step2.ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import step2.domain.BonusNumber;
import step2.domain.Lotto;
import step2.domain.LottoNumber;
import step2.domain.Money;
import step2.domain.WinningLotto;

public class InputView {

    public static Money inputMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        final long money = scanner.nextLong();
        return new Money(money);
    }

    public static WinningLotto inputWinningLotto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String numbersLine = scanner.nextLine();
        List<LottoNumber> numbers = Arrays.stream(numbersLine.split(", "))
                                          .map(Integer::parseInt)
                                          .map(LottoNumber::new)
                                          .collect(Collectors.toList());
        return new WinningLotto(new Lotto(numbers));
    }

    public static BonusNumber inputBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        int number = scanner.nextInt();
        return new BonusNumber(number);
    }
}
