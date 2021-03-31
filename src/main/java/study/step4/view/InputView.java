package study.step4.view;

import static java.util.stream.Collectors.*;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import study.step4.domain.LottoTicketCount;
import study.step4.util.StringUtil;

public class InputView {
    private final static String MESSAGE_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private final static String MESSAGE_WIN_NUMBER = "\n지난 주 당첨 번호를 입력해 주세요.";
    private final static String MESSAGE_BONUS_BALL = "\n보너스 볼을 입력해주세요.";
    private final static String MESSAGE_MANUAL_COUNT = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    private final static String MESSAGE_MANUAL_NUMBER = "\n수동으로 구매할 번호를 입력해주세요.";
    private final static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String inputPurchaseAmount() {
        System.out.println(MESSAGE_PURCHASE_AMOUNT);
        return scanner.nextLine();
    }

    public static String[] inputWinNumber() {
        System.out.println(MESSAGE_WIN_NUMBER);
        return StringUtil.split(scanner.nextLine());
    }

    public static String inputBonusBall() {
        System.out.println(MESSAGE_BONUS_BALL);
        return scanner.nextLine();
    }

    public static String inputManualCount() {
        System.out.println(MESSAGE_MANUAL_COUNT);
        return scanner.nextLine();
    }

    public static List<String> inputManualNumber(LottoTicketCount count) {
        System.out.println(MESSAGE_MANUAL_NUMBER);
        return IntStream.range(0, count.getLottoTicketCount())
            .mapToObj(i -> scanner.nextLine())
            .collect(toList());
    }
}
