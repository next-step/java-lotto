package lotto.dto;

import java.util.List;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean isContain(int bonusNumber) {
        return lottoNumbers.stream()
                .anyMatch(lottoNumber -> bonusNumber == lottoNumber.getLottoNumber());
    }

    public int countMatchNumber(List<Integer> winningNumber) {
        return (int) lottoNumbers.stream()
                .filter(lottoNumber -> winningNumber.contains(lottoNumber.getLottoNumber()))
                .count();
    }
}
