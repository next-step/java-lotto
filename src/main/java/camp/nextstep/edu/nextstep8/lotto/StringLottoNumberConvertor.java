package camp.nextstep.edu.nextstep8.lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StringLottoNumberConvertor {
    private static final String EMPTY = "";
    private static final String SEPARATOR = ",";
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    private StringLottoNumberConvertor(){}

    public static List<Integer> convert(String lottoNumberStr) {
        List<Integer> lottoNumbers =  makeLottoNumbers(lottoNumberStr);
        validateCount(lottoNumbers);
        return lottoNumbers;
    }

    private static List<Integer> makeLottoNumbers(String lottoNumberStr) {
        validateEmpty(lottoNumberStr);
        return Arrays.stream(lottoNumberStr.split(SEPARATOR))
                .map(Integer::parseInt)
                .map(n -> validateNumber(n))
                .distinct()
                .collect(Collectors.toList());
    }

    private static void validateEmpty(String str) {
        if(Objects.isNull(str) || EMPTY.equals(str)) {
            throw new IllegalArgumentException("번호가 없습니다");
        }
    }

    private static int validateNumber(int number) {
        if(LOTTO_MIN_NUMBER > number || LOTTO_MAX_NUMBER < number) {
            throw new IllegalArgumentException("잘못된 번호 입니다 : " + number);
        }
        return number;
    }

    private static void validateCount(List<Integer> numbers) {
        if(LOTTO_NUMBER_COUNT != numbers.size()) {
            throw new IllegalArgumentException("번호의 개수는 6개여야 합니다 : " + numbers.size());
        }
    }
}
