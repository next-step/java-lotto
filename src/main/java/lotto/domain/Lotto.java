package lotto.domain;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import lotto.view.LottoResult;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(Collection<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers
            .stream()
            .distinct()
            .sorted()
            .collect(Collectors.toList());
        this.validate();
    }

    private void validate() {
        if (lottoNumbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    public int getMatchCount(WinningLotto winningLotto) {
        return (int) this.lottoNumbers.stream()
            .filter(winningLotto::contains)
            .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public LottoResult toResult() {
        List<Integer> numbers = this.lottoNumbers
            .stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());
        return new LottoResult(numbers);
    }

}
