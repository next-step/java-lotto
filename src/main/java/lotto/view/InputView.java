package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.PurchaseAction;

public class InputView {

    private static final String COMMA = ",";
    private static final String MESSAGE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_LAST_WEEK_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_BONUS = "보너스 볼을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static PurchaseAction getAmount() {
        System.out.println(MESSAGE_AMOUNT);
        return new PurchaseAction(scanner.nextInt());
    }

    public static LottoNumbers getComparisonNumbers() {
        scanner.nextLine();
        System.out.println();
        System.out.println(MESSAGE_LAST_WEEK_NUMBERS);

        return new LottoNumbers(
            Arrays.stream(scanner.nextLine().split(COMMA))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList())
        );
    }

    public static int getBonus() {
        System.out.println(MESSAGE_BONUS);
        return scanner.nextInt();
    }
}
