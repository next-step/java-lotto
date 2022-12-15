package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.exception.NotPositiveException;
import lotto.strategy.ManualNumberStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {

    private static final Scanner SCANNER = new Scanner(System.in);

    private UserInput() {
    }

    public static Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(optionalOf(SCANNER.nextLine()));
    }

    public static int inputManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String input = SCANNER.nextLine();
        checkPositive(input);
        return Integer.parseInt(optionalOf(input));
    }

    public static List<Lotto> inputManualLottos(int manualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            manualLottos.add(new Lotto(new ManualNumberStrategy(optionalOf(SCANNER.nextLine()))));
        }
        return manualLottos;
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

    private static void checkPositive(String input) {
        Matcher matcher = Pattern.compile("^[0-9]*$").matcher(input);
        if (!matcher.find()) {
            throw new NotPositiveException();
        }
    }
}
