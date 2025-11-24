package lotto.view;

import lotto.domain.PurchasedLottos;
import lotto.domain.Lotto;
import lotto.domain.LottoPrice;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private static final String START_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_COUNT_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String RESULT_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해주세요.";
    private static final String PASSIVE_BUY_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String PASSIVE_BUY_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    public static int inputBuyPrice() {
        return scanner.nextInt();
    }

    public static void printLottoCount(LottoPrice lottoPrice) {
        System.out.println(String.format(
                LOTTO_COUNT_MESSAGE,
                lottoPrice.getTicketCount().getPassiveTicketCount(),
                lottoPrice.getTicketCount().getAutoTicketCount())
        );
    }

    public static void printBuyLotto(PurchasedLottos purchasedLottos) {
        purchasedLottos.getLottos().stream().forEach(System.out::println);
    }

    public static void printPassiveBuyLottoCount() {
        System.out.println(PASSIVE_BUY_COUNT_MESSAGE);
    }

    public static void printPassiveBuyLotto() {
        System.out.println(PASSIVE_BUY_MESSAGE);
    }

    public static void inputPassiveBuyLotto(PurchasedLottos purchasedLottos, int count) {
        scanner.nextLine();
        for (int i = 0; i < count; i++) {
            purchasedLottos.add(new Lotto(StringToIntegerArray(scanner.next())));
        }
    }

    public static int inputPassiveBuyLottoCount() {
        return scanner.nextInt();
    }

    public static void printResultLottoNumber() {
        System.out.println(RESULT_LOTTO_MESSAGE);
    }

    public static Lotto inputResultLottoNumber() {
        scanner.nextLine();
        return new Lotto(StringToIntegerArray(scanner.nextLine()));
    }

    public static void printBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
    }

    public static int inputBonusNumber() {
        return scanner.nextInt();
    }

    private static Integer[] StringToIntegerArray(String input) {
        return Arrays.stream(splitString(input)).map(Integer::parseInt).toArray(Integer[]::new);
    }

    private static String[] splitString(String input) {
        return input.replaceAll(" ", "").split(",");
    }
}
