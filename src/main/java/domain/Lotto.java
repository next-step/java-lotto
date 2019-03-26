package domain;

import util.RandomNumberGenerator;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final Integer limitCount = 6;

    private Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != limitCount){
            throw new IllegalArgumentException();
        }

        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto create(NumberSet numberSet) {
        if(numberSet.isEmpty()) {
            return auto();
        }

        return manual(numberSet);
    }

    private static Lotto auto() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();

        while(lottoNumbers.size() < limitCount) {
            lottoNumbers.add(LottoNumber.of(RandomNumberGenerator.generateNumber(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)));
        }

        return new Lotto(lottoNumbers);
    }

    private static Lotto manual(NumberSet numberSet) {
        return new Lotto(numberSet.getNumbers().stream()
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
}
