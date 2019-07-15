package lottogame.domain;

import java.util.*;

public enum LottoUtil {
    BLANK(" "), NOTHING(""), REST(",");

    private final static int ONE_UNIT_OF_LOTTO = 6;
    private final static int ZERO = 0;
    private final static int LOTTO_MAXIMUM_NUMBER = 45;

    private String value;

    LottoUtil(String input) {
        value = input;
    }

    public String getValue() {
        return value;
    }

    public static void checkNumberOfLotto(int input) {
        if (input < ZERO)
            throw new IllegalArgumentException("수량이 잘못입력되었습니다. 다시 실행 후 1이상 숫자를 입력해주세요.");
    }

    public static int checkBonusball(int input) {
        if (input <= ZERO || input > LOTTO_MAXIMUM_NUMBER)
            throw new IllegalArgumentException("보너스볼 번호가 잘못입력되었습니다. 다시 실행 후 올바른 숫자를 입력해주세요.");
        return input;
    }

    public static int[] covertStrToArr(String inputWinningNumber) {
        String[] result = removeBlankAndSplit(inputWinningNumber);
        checkInputElement(result);

        int[] WinningNumber = new int[ONE_UNIT_OF_LOTTO];
        for (int i = 0; i < ONE_UNIT_OF_LOTTO; ++i) {
            WinningNumber[i] = Integer.parseInt(result[i]);
        }
        return WinningNumber;
    }

    public static ArrayList<Integer> covertStrToArrList(String inputWinningNumber) {
        String[] result = removeBlankAndSplit(inputWinningNumber);
        checkInputElement(result);

        ArrayList<Integer> WinningNumber = new ArrayList<>();
        for (int i = 0; i < ONE_UNIT_OF_LOTTO; ++i) {
            WinningNumber.add(Integer.parseInt(result[i]));
        }
        return WinningNumber;
    }

    public static void checkLottoNumber(List<Integer> input) {
        if (isInputCountLowerThanNormal(input)) {
            throw new IllegalArgumentException("로또 번호의 입력이 잘못되었습니다. 다시 프로그램을 실행해주세요.");
        }

        for (int value : input) {
            checkIfLottoNumberOutOfBound(value);
        }
        checkDuplicate(input);
    }

    private static void checkIfLottoNumberOutOfBound(int value) {
        if (value <= ZERO || value > LOTTO_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException("입력한 로또 숫자가 잘못되었습니다. 프로그램을 종료합니다.");
        }
    }

    private static void checkDuplicate(List<Integer> input) {
        Set<Integer> result = new HashSet<>(input);
        if (result.size() != ONE_UNIT_OF_LOTTO) {
            throw new IllegalArgumentException("입력한 로또 값에 중복이 있습니다. 프로그램을 종료합니다");
        }

    }

    private static void checkInputElement(String[] input) {
        if (input.length != ONE_UNIT_OF_LOTTO) {
            throw new IllegalArgumentException("로또 번호의 입력이 잘못되었습니다. 다시 프로그램을 실행해주세요.");
        }

    }

    private static boolean isInputCountLowerThanNormal(List<Integer> input) {
        return input.size() != ONE_UNIT_OF_LOTTO;
    }

    private static String[] removeBlankAndSplit(String input) {
        return input.replaceAll(BLANK.getValue(), NOTHING.getValue()).split(REST.getValue());
    }
}
