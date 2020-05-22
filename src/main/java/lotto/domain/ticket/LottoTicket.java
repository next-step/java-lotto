package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;
import lotto.domain.prize.Prize;
import lotto.exception.ErrorMessage;

import java.util.List;

public class LottoTicket {

    private final LottoNumbers lottoNumbers;

    LottoTicket(final LottoNumbers lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket of(final LottoNumbers lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    private void validate(final LottoNumbers lottoNumbers) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException(ErrorMessage.NULL_VALUE);
        }
    }

    public Prize matchPrize(final WinningLottoTicket winningLottoTicket) {
        int matchCount = lottoNumbers.matchCount(winningLottoTicket);
        return Prize.of(matchCount);
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public List<Integer> getLottoNumbersToInts() {
        return lottoNumbers.getNumbersToInts();
    }
}
