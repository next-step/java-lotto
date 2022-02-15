package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.model.LottoNumber;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PRICE_INPUT_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING__NUMBER_INPUT_GUIDE_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_INPUT_GUIDE_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String THE_NUMBER_OF_MANUAL_LOTTO_INPUT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBER_INPUT_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    public static int inputPrice() {
        System.out.println(PRICE_INPUT_GUIDE_MESSAGE);
        return SCANNER.nextInt();
    }

    public static int inputManualLottoCount() {
        System.out.println(THE_NUMBER_OF_MANUAL_LOTTO_INPUT_MESSAGE);
        return SCANNER.nextInt();
    }

    public static List<List<Integer>> inputManualLottoNumber(int amountOfManualLotto) {
        List<List<Integer>> manualLottos = new ArrayList<>();
        System.out.println(MANUAL_LOTTO_NUMBER_INPUT_MESSAGE);
        for (int i = 0; i < amountOfManualLotto; i++) {
            String manualLottoNumberInput = SCANNER.next();
            String[] manualLottoNumber = manualLottoNumberInput.split("[ ,]");
            List<Integer> list = Arrays.stream(manualLottoNumber).map(Integer::parseInt).collect(
                Collectors.toList());
            manualLottos.add(list);
        }
        return manualLottos;
    }

    public static List<String> inputWinningNumbers() {
        System.out.println(WINNING__NUMBER_INPUT_GUIDE_MESSAGE);
        String inputWinningNumbers = SCANNER.next();
        return Arrays.asList(inputWinningNumbers.split("[ ,]"));
    }

    public static LottoNumber inputBonusBall() {
        System.out.println(BONUS_BALL_INPUT_GUIDE_MESSAGE);
        int inputBonusBall = SCANNER.nextInt();
        return new LottoNumber(inputBonusBall);
    }
}
