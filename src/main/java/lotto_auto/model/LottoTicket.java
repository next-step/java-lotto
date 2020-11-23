package lotto_auto.model;

import lotto_auto.ErrorMessage;


public class LottoTicket {

    private LottoNumbers lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = LottoNumberManager.generate();
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumbers;
    }

    public DrawResult draw(LottoNumbers winningLottoNumbers) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NULL_WINNING_LOTTO_TICKET);
        }
        int matchNumberCount = this.lottoNumbers.computeMatchCount(winningLottoNumbers);
        return DrawResult.valueOfMatchNum(matchNumberCount);
    }
}
