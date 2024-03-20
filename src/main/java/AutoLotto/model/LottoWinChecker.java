package autoLotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWinChecker {

    private int[] winLottos;

    private static final int LOTTO_WIN_CHECKER_RESULT_LENGTH = 5;
    private static final int START_WIN_NUMBER = 1;
    private static final int END_WIN_NUMBER = 45;
    private static final int VALID_WIN_NUMBERS_LENGTH = 6;
    private static final String INVALID_WIN_NUMBERS = "당첨 번호의 개수는 6개이며, 각 번호는 1 이상 45 이하의 값만 가능합니다.";

    public LottoWinChecker(String winNumbersInString, List<Lotto> lottos) {
        int[] winNumbers = convertStringToInts(winNumbersInString);
        if (!isValidWinNumbers(winNumbers)) {
            throw new IllegalArgumentException(INVALID_WIN_NUMBERS);
        }
        this.winLottos = startWinCheck(winNumbers, lottos);
    }

    private int[] convertStringToInts(String input) {
        String[] values = splitNumbersByComma(input);
        return stringsToInts(values);
    }

    private int[] stringsToInts(String[] values) {
        int[] numbers = new int[values.length];

        for (int i = 0; i < VALID_WIN_NUMBERS_LENGTH; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }

        return numbers;
    }

    private String[] splitNumbersByComma(String input) {
        return input.split(",");
    }

    private boolean isValidWinNumbers(int[] winNumbers) {
        if (winNumbers.length != VALID_WIN_NUMBERS_LENGTH) {
            return false;
        }

        Arrays.sort(winNumbers);
        return isNumberInValidRange(winNumbers[0]) && isNumberInValidRange(winNumbers[LOTTO_WIN_CHECKER_RESULT_LENGTH - 1]);
    }

    private boolean isNumberInValidRange(int number) {
        return number >= START_WIN_NUMBER && number <= END_WIN_NUMBER;
    }

    private int[] startWinCheck(int[] winNumbers, List<Lotto> lottos) {
        List<Integer> winNumberList = intsToList(winNumbers);
        int[] result = new int[LOTTO_WIN_CHECKER_RESULT_LENGTH];

        for (Lotto lotto : lottos) {
            int countOfWinNumbers = compareWinNumbers(winNumberList, lotto);
            result[matchWinNumbersWithIndex(countOfWinNumbers)]++;
        }

        return result;
    }

    private List<Integer> intsToList(int[] winNumbers) {
        return Arrays.stream(winNumbers)
                .boxed()
                .collect(Collectors.toList());
    }

    private int compareWinNumbers(List<Integer> winNumberList, Lotto lotto) {
        int[] targetLotto = lotto.getLotto();
        int matchingNumbers = 0;

        for (int number : targetLotto) {
            matchingNumbers += hasWinNumber(winNumberList, number);
        }

        return matchingNumbers;
    }

    private int matchWinNumbersWithIndex(int countOfWinNumbers) {
        if (countOfWinNumbers < 3) {
            return 0;
        }

        return countOfWinNumbers - 2;
    }

    private int hasWinNumber(List<Integer> winNumberList, int targetNumber) {
        if(winNumberList.contains(targetNumber)) {
            return 1;
        }

        return 0;
    }

    public int[] getWinLottos() {
        return this.winLottos;
    }
}
