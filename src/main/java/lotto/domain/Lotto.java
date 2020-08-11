package lotto.domain;

import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Set;

import static com.google.common.base.Preconditions.checkArgument;

public class Lotto {

    public static final int LOTTO_NUMBER_COUNT = 6;

    private static final String NUMBER_DELIMITER = ",";
    private static final String TEXT_BLANK_MESSAGE = "text not allowed null or empty";
    private static final String NUMBER_COUNT_MESSAGE = "number count must be {0}";

    private final Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int countOfMatch(Lotto lotto) {
        long countOfMatch = lottoNumbers.stream()
            .filter(lotto::contain)
            .count();
        return Math.toIntExact(countOfMatch);
    }

    public int[] toArray() {
        return lottoNumbers.stream()
                .mapToInt(LottoNumber::getNumber)
                .toArray();
    }

    public boolean contain(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public static Lotto generateAuto() {
        return new Lotto(LottoNumberGenerator.shuffleAndGet());
    }

    public static Lotto fromString(String text) {
        checkArgument(StringUtils.isNotBlank(text), TEXT_BLANK_MESSAGE);

        String[] tokens = text.split(NUMBER_DELIMITER);
        checkArgument(tokens.length == LOTTO_NUMBER_COUNT,
            MessageFormat.format(NUMBER_COUNT_MESSAGE, LOTTO_NUMBER_COUNT));

        Set<LottoNumber> newNumbers = new HashSet<>();
        for (String token : tokens) {
            newNumbers.add(LottoNumber.of(token));
        }

        return new Lotto(newNumbers);
    }

}
