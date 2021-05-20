package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int INIT_INDEX = 0;
    public static final int SIZE = 6;
    private static final String DELIMITER = ",";
    private static final String SIZE_EXCEPTION = "로또 번호는 6자리여야 합니다.";
    private static final String NULL_OR_EMPTY_EXCEPTION = "로또번호는 Null이나 빈 값을 입력할 수 없습니다.";

    private final Set<LottoNumber> lottoNumbers;

    private LottoNumbers(Set<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException(SIZE_EXCEPTION);
        }
    }

    public LottoNumbers(int... lottoNumber) {
        this(initNumbers(lottoNumber));
    }

    private static Set<LottoNumber> initNumbers(int[] lottoNumber) {
        return Arrays.stream(lottoNumber)
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toSet());
    }

    public static LottoNumbers valueOf(String lottoNumbers) {
        validateNullOrEmpty(lottoNumbers);
        String[] splited = lottoNumbers.split(DELIMITER);
        return new LottoNumbers(
                Arrays.stream(splited)
                        .map(LottoNumber::valueOf)
                        .collect(Collectors.toSet())
        );
    }

    private static void validateNullOrEmpty(String lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.trim().isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_EXCEPTION);
        }
    }

    public Set<LottoNumber> getValue() {
        return new TreeSet<>(lottoNumbers);
    }

    public int matchNumbers(LottoNumbers other) {
        List<LottoNumber> retainNumbers = new ArrayList<>(other.lottoNumbers);
        retainNumbers.retainAll(this.lottoNumbers);
        return retainNumbers.size();
    }
}
