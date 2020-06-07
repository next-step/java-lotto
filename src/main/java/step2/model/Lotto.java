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
    private final static int PLUS_ZERO= 0;

    private static final String EXCEPTION_NOT_NUMBER = "숫자만 입력해 주세요";
    private static final String EXCEPTION_OVER_NUMBER = "총 6개의 숫자를 입력해야 합니다.";
    private static final String EXCEPTION_SIX_NUMBER = "숫자의 범위는 1 ~ 45 입니다.";

    private static final String DELIMETER = ",";

    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> inputLottoNumberList) {
        validateNumbers(inputLottoNumberList);
        lottoNumbers = inputLottoNumberList;
    }

    public Lotto(String inputWinnerNumbers) {
        List<Integer> convertLottoNumber = convertStringtoNumbers(inputWinnerNumbers);
        validateNumbers(convertLottoNumber);
        lottoNumbers = convertLottoNumber;
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
    }

    private void checkNumber(List<Integer> lottoNumbers) {
        lottoNumbers.stream()
            .forEach(number -> {
                if (number > MAX || number < MIN) {
                    throw new IllegalArgumentException(EXCEPTION_SIX_NUMBER);
                }
            });
    }

    private void checkSize(List<Integer> lottoNumbers) {
        int cnt = (int) lottoNumbers.stream()
                .distinct()
                .count();

        if (cnt != SIZE) {
            throw new IllegalArgumentException(EXCEPTION_OVER_NUMBER);
        }
    }

    private List<Integer> convertStringtoNumbers(String inputWinnerNumbers) {
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
