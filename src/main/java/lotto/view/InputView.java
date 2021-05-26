package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String COUNT_OF_MANUAL_LOTTO_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String WINNING_LOTTO_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String MANUAL_LOTTOES_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String NUMBER_REGEX = "[^0-9,]";
    private static final String LOTTO_NUMBERS_SEPARATOR = ",";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    public static int inputAmount() {
        System.out.println(AMOUNT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static int inputCountOfManualLotto() {
        System.out.println(String.format("%n%s", COUNT_OF_MANUAL_LOTTO_MESSAGE));
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<List<Integer>> inputManualLottoes(int countOfManualLotto) {
        System.out.println(String.format("%n%s", MANUAL_LOTTOES_MESSAGE));
        List<List<Integer>> manualLottoes = new ArrayList<>();
        for (int i = 0; i < countOfManualLotto; i++) {
            manualLottoes.add(inputLottoNumbers());
        }
        return manualLottoes;
    }

    public static List<Integer> inputWinningLottoNumbers() {
        System.out.println(String.format("%n%s", WINNING_LOTTO_NUMBERS_MESSAGE));
        return inputLottoNumbers();
    }

    private static List<Integer> inputLottoNumbers() {
        String lottoNumberString = scanner.nextLine().replaceAll(NUMBER_REGEX, "");
        String[] winningLottoNumbers = lottoNumberString.split(LOTTO_NUMBERS_SEPARATOR);
        return Arrays.stream(winningLottoNumbers)
                .map(lottoNumber -> Integer.valueOf(lottoNumber))
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }
}
