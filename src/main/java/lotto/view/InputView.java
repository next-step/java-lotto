package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    public static final String PURCHASE_AMOUNT_INPUT_MSG = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBER_INPUT_MSG = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String BONUS_BALL_INPUT_MSG = "보너스 볼을 입력해 주세요.";
    private static final String MANUAL_COUNT_INPUT_MSG = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String LOTTO_NUMBERS_INPUT_MSG = "수동으로 구매할 번호를 입력해 주세요.";

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int readPurchaseAmount() {
        return getNumberFromStdin(PURCHASE_AMOUNT_INPUT_MSG);
    }

    public String readWinningNumber() {
        return getStringFromStdin(WINNING_NUMBER_INPUT_MSG);
    }

    public int readBonusNumber() {
        return getNumberFromStdin(BONUS_BALL_INPUT_MSG);
    }

    public List<String> readLottoNumbers() {
        int manualCount = getNumberFromStdin(MANUAL_COUNT_INPUT_MSG);

        System.out.println(LOTTO_NUMBERS_INPUT_MSG);
        return IntStream.rangeClosed(1,manualCount)
                .mapToObj(it -> scanner.nextLine()).collect(Collectors.toList());
    }

    private String getStringFromStdin(String displayText) {
        System.out.println(displayText);
        return scanner.nextLine();
    }

    private int getNumberFromStdin(String displayText) {
        System.out.println(displayText);
        return Integer.valueOf(scanner.nextLine());
    }

    @Override
    protected void finalize() throws Throwable {
        this.scanner.close();
        super.finalize();
    }

}
