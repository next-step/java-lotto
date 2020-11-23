package lotto_auto.model;

import lotto_auto.ErrorMessage;


public class LottoTicket {

    public final static int PRICE = 1000;

    private LottoNumber lottoNumber;

    public LottoTicket() {
        this.lottoNumber = LottoNumberManager.generate();
    }

    public LottoNumber getLottoNumber() {
        return this.lottoNumber;
    }

    public LottoResult draw(LottoNumber winningLottoNumber) {
        if (lottoNumber == null) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NULL_WINNING_LOTTO_TICKET);
        }
        int matchNumberCount = this.lottoNumber.computeMatchCount(winningLottoNumber);
        return LottoResult.valueOfMatchNum(matchNumberCount);
    }
}
