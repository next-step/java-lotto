package lotto;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    public static final String LOTTO_WINNER_NUMBER_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String LOTTO_WINNER_BONUS_NUMBER_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";
    public static final String LOTTO_BUY_AMT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public static int inputBuyLottoPrice() {
        System.out.println(LOTTO_BUY_AMT_INPUT_MESSAGE);
        int buyPrice = scanner.nextInt();
        return buyPrice;
    }

    public static Lotto inputWinnerLottoNumber() {
        System.out.println(LOTTO_WINNER_NUMBER_INPUT_MESSAGE);
        LottoNumber[] inputNumbers = Arrays.stream(scanner.next().replaceAll(" ", "").split(",")).map(LottoNumber::new).toArray(LottoNumber[]::new);
        LottoNumber bonusNumber = inputWinnerBonusLottoNumber();
        Lotto lotto = new Lotto(inputNumbers, bonusNumber);
        return new Lotto(inputNumbers, bonusNumber);
    }

    public static LottoNumber inputWinnerBonusLottoNumber() {
        System.out.println(LOTTO_WINNER_BONUS_NUMBER_INPUT_MESSAGE);
        return new LottoNumber(Integer.parseInt(scanner.next()));
    }
}
