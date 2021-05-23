package lotto.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Lotto {

    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusNumber;

    public Lotto(LottoNumbers lottoNumbers, LottoNumber bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Lotto(Collection<LottoNumber> numbers, LottoNumber bonusNumber) {
        this(new LottoNumbers(numbers), bonusNumber);
    }

    public static Lotto of(Collection<Integer> numbers, LottoNumber bonusNumber) {
        return new Lotto(numbers.stream()
                                .map(LottoNumber::of)
                                .collect(toList()), bonusNumber);
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

    public int getMatchCount(Lotto lotto) {
        return lottoNumbers.getMatchCount(lotto.getLottoNumbers());
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
