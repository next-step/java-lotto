package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return "[" + lottoNumbers.stream()
                .map(lottoNumber -> String.valueOf(lottoNumber.getLottoNumber()))
                .collect(Collectors.joining(", ")) + "]";
    }

    public boolean checkBonusNumber(WinningNumber winningNumber) {
        return lottoNumbers.contains(winningNumber.getBonusNumber());
    }

}
