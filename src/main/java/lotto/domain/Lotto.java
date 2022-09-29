package lotto.domain;

import lotto.domain.type.Match;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumber.LOTTO_NUMBERS;

public class Lotto {
    public static final int PRICE = 1000;
    private static final int LOTTO_SIZE = 6;
    private static final String DEFAULT_DELIMITER = ",";
    private static final String LOTTO_NUMBER_EXCEPTION_MESSAGE = "로또 번호는 6개 이어야 합니다.";

    private final List<LottoNumber> lottoNumbers;

    public static Lotto create() {
        Collections.shuffle(LOTTO_NUMBERS);
        return new Lotto(LOTTO_NUMBERS.stream()
                .limit(LOTTO_SIZE)
                .collect(Collectors.toList()));
    }

    public static Lotto create(String lottoNumbers) {
        StringTokenizer tokenizer = new StringTokenizer(lottoNumbers, DEFAULT_DELIMITER);

        List<LottoNumber> numbers = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            String number = tokenizer.nextToken();
            numbers.add(LottoNumber.of(number));
        }

        return new Lotto(numbers);
    }

    public Lotto(List<LottoNumber> lottoNumbers) {
        checkSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void checkSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public Match rank(Lotto other) {
        return Match.findType(matchCount(other));
    }

    public int matchCount(Lotto other) {
        return (int) lottoNumbers.stream()
                .filter(other.lottoNumbers::contains)
                .count();
    }

    public List<LottoNumber> lottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
