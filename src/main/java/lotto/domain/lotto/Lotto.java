package lotto.domain.lotto;

import lotto.domain.WinningNumbers;
import lotto.exception.InvalidLottoException;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    public static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        validateSizeOfLottoNumbers(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSizeOfLottoNumbers(List<LottoNumber> lottoNumbers) {
        int sizeOfLottoNumbers = lottoNumbers.size();
        int sizeOfLottoNumbersSet = new HashSet<>(lottoNumbers).size();

        if(sizeOfLottoNumbers != sizeOfLottoNumbersSet || sizeOfLottoNumbers != LOTTO_NUMBER_SIZE) {
            throw new InvalidLottoException();
        }
    }

    public static Lotto valueOf(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public int countOfMatch(WinningNumbers winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public List<LottoNumber> lottoNumbers() {
        return lottoNumbers;
    }
}
