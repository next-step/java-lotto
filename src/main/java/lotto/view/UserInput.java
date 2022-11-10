package lotto.view;

import lotto.domain.BonusBall;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.strategy.ManualNumberStrategy;
import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class UserInput {

    private static final Scanner SCANNER = new Scanner(System.in);

    private UserInput() {
    }

    public static Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(checkNull(SCANNER.nextLine()));
    }

    public static ManualNumberStrategy inputWinningLotto() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new ManualNumberStrategy(checkNull(SCANNER.nextLine()));
    }

    public static BonusBall inputBonusBall(Lotto winningLotto) {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new BonusBall(checkNull(SCANNER.nextLine()), winningLotto);
    }

    private static String checkNull(String input) {
        if (StringUtils.isBlank(input)) {
            throw new NullPointerException("빈값은 허용되지 않습니다. 값을 입력해주세요.");
        }
        return input;
    }
}
