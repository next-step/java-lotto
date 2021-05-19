package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int INIT_INDEX = 0;
    public static final int SIZE = 6;
    private static final String SIZE_EXCEPTION = "로또 번호는 6자리여야 합니다.";
    private static final String DELIMITER = ",";

    private final Set<Integer> lottoNumbers;

    private LottoNumbers(Set<Integer> lottoNumbers) {
        validateSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(Set<Integer> lottoNumbers) {
        if (lottoNumbers.size() != SIZE) {
            throw new IllegalArgumentException(SIZE_EXCEPTION);
        }
    }

    public LottoNumbers(int... lottoNumber) {
        this(initNumbers(lottoNumber));
    }

    private static Set<Integer> initNumbers(int[] lottoNumber) {
        return Arrays.stream(lottoNumber)
                    .boxed()
                    .collect(Collectors.toSet());
    }

    public static LottoNumbers valueOf(String lottoNumbers) {
        String[] splited = lottoNumbers.split(DELIMITER);
        return new LottoNumbers(
                Arrays.stream(splited)
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet())
        );
    }

    public Set<Integer> getValue() {
        return new TreeSet<>(lottoNumbers);
    }

    public int matchNumbers(LottoNumbers other) {
        List<Integer> retainNumbers = new ArrayList<>(other.lottoNumbers);
        retainNumbers.retainAll(this.lottoNumbers);
        return retainNumbers.size();
    }
}
