package step2.domain;

public class LastWinningLottoNumberChecker {
    private static final String LOTTO_COUNT_ERROR_MESSAGE = "로또 당첨번호는 6개를 입력하세요. 당첨번호는 ', '로 구분을 하고 있습니다.";
    private static final String LOTTO_NUMBER_RANGE_ERROR_MESSAGE = "로또 당첨번호는 1과 46 사이의 정수이어야 합니다.";
    private static final int COUNT_OF_LOTTO_WINNING_NUMBER = 6;
    private static final String LOTTO_DELIMITER = ", ";
    private static final int MIN_OF_LOTTO_NUMBER = 1;
    private static final int MAX_OF_LOTTO_NUMBER = 46;
    private final int[] lastWinningLottoNumberArray;

    public LastWinningLottoNumberChecker(String lastWinningLottoNum) {
        int[] lottoNumberIntegerArray = makeIntegerArray(validateCountOfLotto(lastWinningLottoNum));
        lottoLoop(lottoNumberIntegerArray);
        this.lastWinningLottoNumberArray = lottoNumberIntegerArray;
    }

    private int[] makeIntegerArray(String[] lottoNumberStringArray) {
        int[] lottoNumberIntegerArray = new int[COUNT_OF_LOTTO_WINNING_NUMBER];
        for (int i = 0; i < lottoNumberStringArray.length; i++) {
            lottoNumberIntegerArray[i] = Integer.parseInt(lottoNumberStringArray[i]);
        }
        return lottoNumberIntegerArray;
    }

    public void lottoLoop(int[] lottoNumberIntegerArray) {
        for (int lottoNumber : lottoNumberIntegerArray) {
            validatePositiveLottoNum(lottoNumber);
        }
    }

    private void validatePositiveLottoNum(int lottoNumber) {
        if (lottoNumber < MIN_OF_LOTTO_NUMBER || lottoNumber > MAX_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    public String[] validateCountOfLotto(String lastWinningLottoNum) {
        String[] lottoNumberStringArray = lastWinningLottoNum.split(LOTTO_DELIMITER);
        int numOfLotto = lottoNumberStringArray.length;
        if (numOfLotto != COUNT_OF_LOTTO_WINNING_NUMBER) {
            throw new IllegalArgumentException(LOTTO_COUNT_ERROR_MESSAGE);
        }
        return lottoNumberStringArray;
    }

    public int[] getLottoWinningNumberArray() {
        return lastWinningLottoNumberArray;
    }
}
