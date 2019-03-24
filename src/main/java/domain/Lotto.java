package domain;

import util.RandomNumberGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final Integer limitCount = 6;

    private Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() != limitCount){
            throw new IllegalArgumentException();
        }

        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto auto() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();

        while(lottoNumbers.size() < limitCount) {
            lottoNumbers.add(LottoNumber.of(RandomNumberGenerator.generateNumber(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)));
        }

        return new Lotto(lottoNumbers);
    }

    public static Lotto manual(List<Integer> numbers) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();

        for (Integer number : numbers) {
            lottoNumbers.add(LottoNumber.of(number));
        }

        return new Lotto(lottoNumbers);
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
