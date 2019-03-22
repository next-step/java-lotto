package domain;

import java.util.*;
import java.util.stream.Stream;

public class Lotto {
    private static final Integer limitCount = 6;

    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    public Lotto() {
        sort(Stream.generate(LottoNumber::getInstance)
            .distinct()
            .limit(limitCount));
    }

    public Lotto(Integer ...numbers){
        if(Arrays.stream(numbers).distinct().count() != limitCount){
            throw new IllegalArgumentException();
        }

        sort(Arrays.stream(numbers)
            .map(LottoNumber::getInstance));
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    private void sort(Stream<LottoNumber> lottoNumberStream){
        lottoNumberStream
            .sorted(Comparator.comparing(LottoNumber::getNumber))
            .forEach(lottoNumbers::add);
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
