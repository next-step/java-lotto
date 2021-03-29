package study.step4.view;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

import study.step4.domain.Amount;
import study.step4.domain.Lotto;
import study.step4.domain.LottoNumber;
import study.step4.domain.Lottos;

public class InputView {
    private final static String MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private final static String MESSAGE_WIN_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private final static String MESSAGE_BONUS_BALL = "보너스 볼을 입력해주세요.";
    private final static String MESSAGE_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private final static String MESSAGE_MANUAL_NUMBER = "수동으로 구매할 번호를 입력해주세요.";
    private final static Scanner scanner = new Scanner(System.in);
    private final static String SPLIT_DELIMITER = ",";

    private InputView() {
    }

    public static String inputPurchaseAmount() {
        System.out.println(MESSAGE_PURCHASE_AMOUNT);
        return scanner.nextLine();
    }

    public static Lotto inputWinNumber() {
        System.out.println(MESSAGE_WIN_NUMBER);
        scanner.nextLine();
        return new Lotto(scanner.nextLine().split(SPLIT_DELIMITER));
    }

    public static String inputBonusBall() {
        System.out.println(MESSAGE_BONUS_BALL);
        return scanner.nextLine();
    }

    public static String inputManualCount() {
        System.out.println(MESSAGE_MANUAL_COUNT);
        return scanner.nextLine();
    }

    public static Lottos inputManualNumber(Amount amount) {
        System.out.println(MESSAGE_MANUAL_NUMBER);
        return new Lottos(IntStream.range(0, amount.getManualCount())
            .mapToObj(i -> scanner.nextLine())
            .map(InputView::apply)
            .collect(toList()));
    }

    private static Lotto apply(String lottoNumbers) {
        return new Lotto(Arrays.stream(lottoNumbers.split(SPLIT_DELIMITER))
            .map(i -> LottoNumber.of(i.trim()))
            .collect(toList()));
    }
}
