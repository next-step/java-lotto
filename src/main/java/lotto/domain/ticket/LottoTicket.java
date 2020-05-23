package lotto.domain.ticket;

import lotto.domain.number.LottoNumbers;
import lotto.domain.prize.Prize;
import lotto.exception.ErrorMessage;

import java.util.List;

public class LottoTicket {

    protected final LottoNumbers lottoNumbers;

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
        int matchCount = lottoNumbers.matchCount(winningLottoTicket.lottoNumbers);
        boolean hasBonusNumber =  lottoNumbers.contains(winningLottoTicket.getBonusNumber());

        return Prize.of(matchCount, hasBonusNumber);
    }

    public List<Integer> getLottoNumbersAsInt() {
        return lottoNumbers.getNumbersAsInt();
    }
}
