package step2.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

    public final static int MIN = 1;
    public final static int MAX = 45;
    public final static int SIZE = 6;

    private final static int PLUS_ONE = 1;
    private final static int PLUS_ZERO = 0;

    private static final String EXCEPTION_NOT_NUMBER = "숫자만 입력해 주세요";
    private static final String EXCEPTION_OVER_NUMBER = "총 6개의 숫자를 입력해야 합니다.";
    private static final String EXCEPTION_DUPLICATION_NUMBER = "중복되지 않은 6개의 숫자를 입력해야 합니다.";
    private static final String EXCEPTION_SIX_NUMBER = "숫자의 범위는 1 ~ 45 입니다.";

    private static final String DELIMETER = ",";

    private List<Integer> lottoNumbers;

    private Lotto(List<Integer> inputLottoNumberList) {
        validateNumbers(inputLottoNumberList);
        lottoNumbers = inputLottoNumberList;
    }

    public static Lotto newListLotto(List<Integer> inputLottoNumberList) {
        return new Lotto(inputLottoNumberList);
    }

    public static Lotto newStringLotto(String inputWinnerNumbers) {
        List<Integer> convertLottoNumber = convertStringToNumbers(inputWinnerNumbers);
        return new Lotto(convertLottoNumber);
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public int checkWinningCount(Lotto winningLotto) {
        int cnt = 0;
        for (Integer number : winningLotto.lottoNumbers) {
            cnt += plusContainNumber(number);
        }
        return cnt;
    }

    public int plusContainNumber(int number) {
        if (lottoNumbers.contains(number)) {
            return PLUS_ONE;
        }

        return PLUS_ZERO;
    }

    public void validateNumbers(List<Integer> lottoNumbers) {
        checkNumber(lottoNumbers);
        checkSize(lottoNumbers);
        countWithoutDuplication(lottoNumbers);
    }

    private void checkNumber(List<Integer> lottoNumbers) {
        lottoNumbers.stream()
                .filter(number -> number > MAX || number < MIN)
                .findAny()
                .ifPresent(number -> {
                    throw new IllegalArgumentException(EXCEPTION_SIX_NUMBER);
                });
    }

    private void checkSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException(EXCEPTION_OVER_NUMBER);
        }
    }

    private void countWithoutDuplication(List<Integer> lottoNumbers) {
        int cnt = (int) lottoNumbers.stream()
                .distinct()
                .count();

        if (cnt != SIZE) {
            throw new IllegalArgumentException(EXCEPTION_DUPLICATION_NUMBER);
        }
    }

    private static List<Integer> convertStringToNumbers(String inputWinnerNumbers) {
        try {
            return Stream.of(inputWinnerNumbers.split(DELIMETER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_NOT_NUMBER, e);
        }
    }
}
