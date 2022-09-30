package lotto.domain;

import lotto.domain.type.Rank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.MAX;
import static lotto.domain.LottoNumber.MIN;


public class Lotto {
    public static final int PRICE = 1000;
    private static final List<LottoNumber> LOTTO_NUMBERS = new ArrayList<>();

    static {
        IntStream.range(MIN, MAX)
                .forEach(i -> LOTTO_NUMBERS.add(new LottoNumber(i)));
    }

    private static final int LOTTO_SIZE = 6;
    private static final String LOTTO_NUMBER_EXCEPTION_MESSAGE = "로또 번호는 6개 이어야 합니다.";

    private final List<LottoNumber> lottoNumbers;

    public static Lotto create() {
        Collections.shuffle(LOTTO_NUMBERS);
        return new Lotto(LOTTO_NUMBERS.stream()
                .limit(LOTTO_SIZE)
                .collect(Collectors.toList()));
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

    public Rank rank(Lotto other) {
        return Rank.findRank(matchCount(other));
    }

    private int matchCount(Lotto other) {
        return (int) lottoNumbers.stream()
                .filter(other.lottoNumbers::contains)
                .count();
    }

    public List<LottoNumber> lottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public List<String> lottoStringNumbers() {
        return lottoNumbers.stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.number()))
                .collect(Collectors.toUnmodifiableList());
    }
}
