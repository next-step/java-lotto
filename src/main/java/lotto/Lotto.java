package lotto;

import lotto.controller.LottoGenerator;

public class Lotto {
    private LottoTicket lottoNumbers;
    private LottoNumber bonusNumber;

    public Lotto() {
        LottoNumber bonusNumber = LottoGenerator.generateBonus();
        this.lottoNumbers = LottoGenerator.generateLotto(bonusNumber);
    }

    public Lotto(LottoTicket lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto(LottoNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int matchLotto(LottoTicket buyerTicket) {
        return this.lottoNumbers.countMatches(buyerTicket);
    }

    public boolean matchBonus(LottoTicket ticket) {
        return this.lottoNumbers.bonusMatches(ticket);
    }

    public LottoTicket getLottoTicket() {
        return lottoNumbers;
    }

    public LottoTicket getLotto() {
        return this.lottoNumbers;
    }

    public LottoNumber getBonusNumber() {
        return this.bonusNumber;
    }
}
