package domain;

import util.RandomNumberGenerator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final Integer LIMIT_COUNT = 6;

    private final Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != LIMIT_COUNT){
            throw new IllegalArgumentException();
        }

        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto create() {
        return auto();
    }

    public static Lotto create(Integer ...numbers) {
        return manual(numbers);
    }

    private static Lotto auto() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();

        while(lottoNumbers.size() < LIMIT_COUNT) {
            lottoNumbers.add(LottoNumber.of(
                RandomNumberGenerator.generateNumber(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)));
        }

        return new Lotto(lottoNumbers);
    }

    private static Lotto manual(Integer[] numbers) {
        return new Lotto(Arrays.stream(numbers)
            .map(LottoNumber::of)
            .collect(Collectors.toSet()));
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public Integer matchCount(Lotto lotto) {
        return (int) lotto.getLottoNumbers().stream()
            .filter(this::contains)
            .count();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }

        if(obj == this) {
            return true;
        }

        if(obj.getClass() == getClass()) {
            Lotto lotto = (Lotto) obj;
            return lottoNumbers.equals(lotto.lottoNumbers);
        }

        return false;
    }
}
