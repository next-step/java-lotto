package lotto.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

import static com.google.common.base.Preconditions.checkArgument;

public class Lotto {

    public static final int LOTTO_NUMBER_SIZE = 6;

    private static final String LOTTO_NUMBER_DELIMITER = ",";
    private static final String INVALID_INPUT_MESSAGE = "Lotto numbers input cannot be null or empty: %s";
    private static final String LOTTO_NUMBER_SIZE_MESSAGE = "Count of Lotto numbers is less than %s";

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        checkArgument(lottoNumbers.size() == LOTTO_NUMBER_SIZE, LOTTO_NUMBER_SIZE_MESSAGE, LOTTO_NUMBER_SIZE);
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(String input) {
        checkArgument(StringUtils.isNotBlank(input), INVALID_INPUT_MESSAGE, input);
        String[] parts = input.split(LOTTO_NUMBER_DELIMITER);

        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (String part : parts) {
            lottoNumbers.add(LottoNumber.of(part.trim()));
        }

        return new Lotto(lottoNumbers);
    }

    public int[] toArray() {
        return lottoNumbers.stream()
                .mapToInt(LottoNumber::getValue)
                .sorted()
                .toArray();
    }

    public int countOfMatch(Lotto lotto) {
        long count = lottoNumbers.stream()
                .filter(lotto::contains)
                .count();
        return Math.toIntExact(count);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }
}
