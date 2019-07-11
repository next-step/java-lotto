package lottogame.domain;

public enum LottoUtil {
    REST(","), BLANK(" "), NOTHING("");

    private final static int ONE_UNIT_OF_LOTTO = 6;
    private final static int ZERO = 0;

    private String value;

    private LottoUtil(String input) {
        value = input;
    }

    public String getValue() {
        return value;
    }

    public static Boolean isNumberZEROOrMinus(int input){
        return input <= ZERO ;
    }

    public static int[] coverStrToArr(String inputWinningNumber) {
        String[] result = removeBlankAndSplit(inputWinningNumber);

        if (checkInputElement(result)) {
            throw new IllegalArgumentException("로또 번호의 입력이 잘못되었습니다. 다시 프로그램을 실행해주세요.");
        }

        int[] inputNumber = new int[ONE_UNIT_OF_LOTTO];
        for (int i = 0; i < ONE_UNIT_OF_LOTTO; ++i) {
            inputNumber[i] = Integer.parseInt(result[i]);
        }
        return inputNumber;
    }

    private static boolean checkInputElement(String[] input) {
        return input.length != ONE_UNIT_OF_LOTTO;
    }

    private static String[] removeBlankAndSplit(String input) {
        return input.replaceAll(BLANK.getValue(), NOTHING.getValue()).split(REST.getValue());
    }
}
