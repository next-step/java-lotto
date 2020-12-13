package lotto.domain.numbers;

import java.util.Arrays;
import java.util.List;

public class LottoTicket {
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public int matchWinningLottoNumbers(WinningLottoNumbers winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::isContain)
                .count();
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 숫자가 부족합니다.");
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(lottoNumbers.stream()
                .mapToInt(LottoNumber::getValue)
                .toArray());
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
