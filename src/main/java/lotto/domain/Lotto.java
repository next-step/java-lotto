package lotto.domain;

import java.util.Collection;

import static java.util.stream.Collectors.toList;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(Collection<LottoNumber> numbers) {
        this(new LottoNumbers(numbers));
    }

    public static Lotto of(Collection<Integer> numbers) {
        return new Lotto(numbers.stream()
                                .map(LottoNumber::of)
                                .collect(toList()));
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    protected boolean contains(LottoNumber number) {
        return lottoNumbers.contains(number);
    }

    protected int getMatchCount(Lotto lotto) {
        return lottoNumbers.getMatchCount(lotto.getLottoNumbers());
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
