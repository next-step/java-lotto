package lotto.domain;

import lotto.wrapper.Money;

public class Lotto {
    public static final Money LOTTO_PRICE = new Money(1000);

    private LottoTicket lottoNumbers;


    private LottoNumber bonusNumber;

    public Lotto() {
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

    public LottoNumber getBonusNumber() { return this.bonusNumber; }

    // 지난 주 로또 당첨 번호, 보너스 번호 입력 받아 setting 하기.
    public void setLottoNumbers(LottoTicket lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void setBonusNumber(LottoNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
