package lotto.domain;

public class Lotto {
    private static final int VALUE_LEFT_BOUND = 1;
    private static final int VALUE_RIHGT_BOUND = 46;

    private static final int COUNT_LEFT_BOUND = 0;
    private static final int COUNT_RIGHT_BOUND = 5;

    private LottoTicket lottoNumbers;

    public Lotto() {
        LottoNumber bonusNumber = LottoGenerator.generateBonus();
        this.lottoNumbers = LottoGenerator.generateLotto(bonusNumber);
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
//    public Lotto(List<Integer> lottoNumbers) {
//        this.lottoNumbers = lottoNumbers;
//    }
//
//    public Lotto(Integer bonusNumber) {
//        this.bonusNumber = bonusNumber;
//    }
//
//    public List<Integer> getLotto() {
//        return this.lottoNumbers;
//    }
//
//    public Integer getBonusNumber() {
//        return this.bonusNumber;
//    }

    private Integer isEqual(Integer users, Integer lotto) {
        if (users == lotto) {
            return 1;
        }
        return 0;
    }
}
