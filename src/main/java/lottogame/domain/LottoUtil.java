package lottogame.domain;

import java.util.*;

public enum LottoUtil {
    REST(","), BLANK(" "), NOTHING("");

    private final static int ONE_UNIT_OF_LOTTO = 6;
    private final static int ZERO = 0;
    private final static int LOTTO_MAXIMUM_NUMBER = 45;

    private String value;

    private LottoUtil(String input) {
        value = input;
    }

    public String getValue() {
        return value;
    }

    public static void checkNumberOfLotto(int input) {
        if (input <= ZERO)
            throw new IllegalArgumentException("수량이 잘못입력되었습니다. 다시 실행 후 1이상 숫자를 입력해주세요.");
    }

    public static int checkBonusball(int input) {
        if (input <= ZERO || input > LOTTO_MAXIMUM_NUMBER)
            throw new IllegalArgumentException("보너스볼 번호가 잘못입력되었습니다. 다시 실행 후 올바른 숫자를 입력해주세요.");
        return input;
    }

    public static int[] coverStrToArr(String inputWinningNumber) {
        String[] result = removeBlankAndSplit(inputWinningNumber);

        if (checkInputElement(result)) {
            throw new IllegalArgumentException("로또 번호의 입력이 잘못되었습니다. 다시 프로그램을 실행해주세요.");
        }

        int[] WinningNumber = new int[ONE_UNIT_OF_LOTTO];
        for (int i = 0; i < ONE_UNIT_OF_LOTTO; ++i) {
            WinningNumber[i] = Integer.parseInt(result[i]) ;
        }
        return WinningNumber;
    }

    public static ArrayList<Integer> coverStrToArrList(String inputWinningNumber) {
        String[] result = removeBlankAndSplit(inputWinningNumber);

        if (checkInputElement(result)) {
            throw new IllegalArgumentException("로또 번호의 입력이 잘못되었습니다. 다시 프로그램을 실행해주세요.");
        }

        ArrayList<Integer> WinningNumber = new ArrayList<>();
        for (int i = 0; i < ONE_UNIT_OF_LOTTO; ++i) {
            WinningNumber.add(Integer.parseInt(result[i])) ;
        }
        return WinningNumber;
    }

    private static boolean checkInputElement(String[] input) {
        return input.length != ONE_UNIT_OF_LOTTO;
    }

    private static String[] removeBlankAndSplit(String input) {
        return input.replaceAll(BLANK.getValue(), NOTHING.getValue()).split(REST.getValue());
    }
}
