package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.dto.LottoDto;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PRICE_INPUT_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING__NUMBER_INPUT_GUIDE_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_INPUT_GUIDE_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String THE_NUMBER_OF_MANUAL_LOTTO_INPUT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBER_INPUT_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final int ZERO = 0;
    private static final String REGEX = "[ ,]";

    public static int inputPrice() {
        System.out.println(PRICE_INPUT_GUIDE_MESSAGE);
        return SCANNER.nextInt();
    }

    public static int inputManualLottoCount() {
        System.out.println(THE_NUMBER_OF_MANUAL_LOTTO_INPUT_MESSAGE);
        return SCANNER.nextInt();
    }

    public static List<LottoDto> inputManualLottoNumber(int manualLottoCount) {
        List<LottoDto> manualLottos = new ArrayList<>();
        System.out.println(MANUAL_LOTTO_NUMBER_INPUT_MESSAGE);
        for (int i = ZERO; i < manualLottoCount; i++) {
            String[] lottoNumbersInput = SCANNER.next().split(REGEX);
            List<Integer> manualLottoNumbers = parseInputNumberToInt(lottoNumbersInput);
            manualLottos.add(new LottoDto(manualLottoNumbers));
        }
        return manualLottos;
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(WINNING__NUMBER_INPUT_GUIDE_MESSAGE);
        String inputWinningNumbers = SCANNER.next();
        String[] winningNumbers = inputWinningNumbers.split(REGEX);
        return parseInputNumberToInt(winningNumbers);
    }

    public static int inputBonusBall() {
        System.out.println(BONUS_BALL_INPUT_GUIDE_MESSAGE);
        return SCANNER.nextInt();
    }

    private static List<Integer> parseInputNumberToInt(String[] inputNumbers) {
        return Arrays.stream(inputNumbers).map(Integer::parseInt).collect(Collectors.toList());
    }
}
