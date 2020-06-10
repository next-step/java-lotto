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

    private static final String DELIMETER = ",";

    private List<Integer> lottoNumbers;

    private Lotto(List<Integer> inputLottoNumberList) {
        LottoNumber.validateNumbers(inputLottoNumberList);
        lottoNumbers = inputLottoNumberList;
        Collections.sort(lottoNumbers);
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

    private int plusContainNumber(int number) {
        if (lottoNumbers.contains(number)) {
            return PLUS_ONE;
        }

        return PLUS_ZERO;
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
