package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.strategy.ManualNumberStrategy;

import java.util.Optional;
import java.util.Scanner;

public class UserInput {

    private static final Scanner SCANNER = new Scanner(System.in);

    private UserInput() {
    }

    public static Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(optionalOf(SCANNER.nextLine()));
    }

    public static ManualNumberStrategy inputWinningLotto() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new ManualNumberStrategy(optionalOf(SCANNER.nextLine()));
    }

    public static LottoNumber inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return LottoNumber.of(optionalOf(SCANNER.nextLine()));
    }

    private static String optionalOf(String input) {
        return Optional.of(input).orElseThrow(() -> new IllegalArgumentException("빈값은 허용되지 않습니다. 값을 입력해주세요."));
    }
}
