package lotto.domain;

public class Lotto {
    private static final int VALUE_LEFT_BOUND = 1;
    private static final int VALUE_RIHGT_BOUND = 46;

    private static final int COUNT_LEFT_BOUND = 0;
    private static final int COUNT_RIGHT_BOUND = 5;

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

    // compare buyers lotto number with answer number
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
