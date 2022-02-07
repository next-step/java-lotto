package lotto.domain;


import java.util.Comparator;
import java.util.List;

public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto(final List<LottoNumber> lottoNumbers) {
        lottoNumbers.sort(Comparator.comparingInt(LottoNumber::get));
        this.lottoNumbers = lottoNumbers;
    }

    public int matchNumber(final List<LottoNumber> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(n -> winningNumbers.contains(n))
                .count();
    }

    public boolean containsBonusNumber(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public List<LottoNumber> get() {
        return this.lottoNumbers;
    }
}
