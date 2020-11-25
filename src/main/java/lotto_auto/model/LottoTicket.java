package lotto_auto.model;

import lotto_auto.ErrorMessage;


public class LottoTicket {

    private LottoNumbers lottoNumbers;
    public static final int PRICE = 1000;

    public LottoTicket() {
        this.lottoNumbers = LottoNumberManager.generate();
    }

    public LottoNumbers getLottoNumbers() {
        return this.lottoNumbers;
    }

    public DrawResult draw(LottoNumbers winningLottoNumbers, LottoNumber bonusNumber) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NULL_WINNING_LOTTO_TICKET);
        }
        int matchNumberCount = this.lottoNumbers.computeMatchCount(winningLottoNumbers);
        boolean bonus = winningLottoNumbers.contains(bonusNumber);
        return DrawResult.valueOf(bonus, matchNumberCount);
    }
}
