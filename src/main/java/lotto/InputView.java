package lotto;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    public static final String LOTTO_WINNER_NUMBER_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String LOTTO_BUY_AMT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public static int inputBuyLottoPrice() {
        System.out.println(LOTTO_BUY_AMT_INPUT_MESSAGE);
        int buyPrice = scanner.nextInt();
        return buyPrice;
    }

    public static void inputWinnerLottoNumber() {
        System.out.println(LOTTO_WINNER_NUMBER_INPUT_MESSAGE);
        String[] inputNumbers = scanner.next().replaceAll(" ", "").split(",");
        LottoWinner.setWinnerLottoNumbers(Arrays.stream(inputNumbers).mapToInt(Integer::parseInt).toArray());
    }
}
