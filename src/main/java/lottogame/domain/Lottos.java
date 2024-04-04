package lottogame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<LottoNumber> lottoNumbers;

    public Lottos(List<Number> numbers) {
        this.lottoNumbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public Lottos(Numbers numbers) {
        this.lottoNumbers = numbers.toLottoNumber();
    }

    public static Lottos from(Numbers numbers) {
        return new Lottos(numbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public int size() {
        return lottoNumbers.size();
    }

    public boolean match(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public int match(Lottos lottos) {
        return (int) lottos.lottoNumbers.stream()
                .filter(this::match)
                .count();
    }
}
