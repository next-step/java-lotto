package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.utils.Parser;

public class InputView {

    private static final String INPUT_BUDGET = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String SPACES = "\\s+";
    private static final String EMPTY_STRING = "";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String EMPTY_INPUT_EXCEPTION_MESSAGE = "입력은 공백일 수 없습니다.";
    private static final String INPUT_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요. (한 줄에 로또 한장을 ','로 구분하여 입력.)";

    private InputView() {}

    public static String inputBudget() {
        System.out.println(INPUT_BUDGET);
        return removedBlankInput();
    }

    public static String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        return removedBlankInput();
    }

    public static String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return removedBlankInput();
    }

    public static List<String> inputManualLottoNumbers() {
        List<String> lottos = new ArrayList<>();
        int numberOfManualLotto = Parser.parseInt(inputNumberOfManualLotto());

        System.out.println();
        while (lottos.size() < numberOfManualLotto) {
            lottos.add(removedBlankInput());
        }

        return lottos;
    }

    private static String inputNumberOfManualLotto() {
        System.out.println(INPUT_MANUAL_LOTTO_NUMBERS);
        return removedBlankInput();
    }

    private static String removedBlankInput() {
        final Scanner sc = new Scanner(System.in);
        final String input = sc.nextLine().trim();
        validateBlank(input);

        return removeBlank(input);
    }

    private static void validateBlank(final String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_EXCEPTION_MESSAGE);
        }
    }

    private static String removeBlank(final String inputNumbers) {
        return inputNumbers.replaceAll(SPACES, EMPTY_STRING);
    }
}
