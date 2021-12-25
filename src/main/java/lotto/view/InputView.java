package lotto.view;

import lotto.lotto.Lottos;
import lotto.lotto.lottonumber.LottoNumber;
import lotto.lotto.lottonumber.LottoNumbers;
import lotto.result.WinningNumbers;

import java.util.Scanner;
import java.util.stream.IntStream;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해주세요.";
    private static final String WINNING_NUMBER_REQUEST_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    public static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해주세요.";
    public static final String MANUAL_SELECTION_REQUEST_MESSAGE = "수동으로 구매할 로또 수를 입력해주세요.";
    public static final String MANUAL_LOTTO_NUMBERS_REQUEST_MESSAGE = "수동으로 구매할 번호를 입력해주세요.";
    public static final int START_VALUE = 0;

    private InputView() {
    }

    public static int getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static Lottos getManualLottos() {
        System.out.println(MANUAL_SELECTION_REQUEST_MESSAGE);
        int quantity = Integer.parseInt(scanner.nextLine());

        System.out.println(MANUAL_LOTTO_NUMBERS_REQUEST_MESSAGE);
        String[] inputs = IntStream.range(START_VALUE, quantity)
                .mapToObj(value -> scanner.nextLine())
                .toArray(String[]::new);

        return Lottos.from(inputs);
    }

    public static WinningNumbers getWinningNumbers() {
        System.out.println(WINNING_NUMBER_REQUEST_MESSAGE);
        LottoNumbers winningNumbers = LottoNumbers.from(scanner.nextLine());

        System.out.println(BONUS_NUMBER_MESSAGE);
        LottoNumber bonusNumber = LottoNumber.from(scanner.nextLine());

        return WinningNumbers.of(winningNumbers, bonusNumber);
    }
}
