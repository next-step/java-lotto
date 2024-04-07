package lotto.view;

import lotto.domain.LottoFee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String QUESTION_START = "구입금액을 입력해 주세요.";
    private static final String QUESTION_MANUAL_GAME_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String QUESTION_MANUAL_GAME_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String QUESTION_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String QUESTION_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    public static int inputPaymentForGames() {
        System.out.println(QUESTION_START);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static int inputManualGameCount() {
        System.out.println(QUESTION_MANUAL_GAME_COUNT);
        return Integer.parseInt(SCANNER.nextLine());
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println(QUESTION_WINNING_NUMBER);
        return selectLottoNumbers();
    }

    public static int inputBonusNumber() {
        System.out.println(QUESTION_BONUS_NUMBER);
        return parseInt(SCANNER.nextLine());
    }

    public static List<List<Integer>> inputManualGameNumber(int count) {
        System.out.println(QUESTION_MANUAL_GAME_NUMBER);
        List<List<Integer>> manualInputLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = selectLottoNumbers();
            manualInputLottos.add(numbers);
        }
        return manualInputLottos;
    }

    private static List<Integer> selectLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        String[] stringNumbers = SCANNER.nextLine().split(", ");
        for (String numberAsString : stringNumbers) {
            numbers.add(Integer.parseInt(numberAsString));
        }
        return numbers;
    }
}
