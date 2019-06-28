package step4.domain;

import java.util.Collections;
import java.util.List;

public class LuckyTicket {
    private final List<LottoNumber> luckyNumber;
    private final LottoNumber bonusNumber;

    private LuckyTicket(List<LottoNumber> luckyNumber, LottoNumber bonusNumber) {
        this.luckyNumber = luckyNumber;
        this.bonusNumber = bonusNumber;
    }

    static LuckyTicket of(List<LottoNumber> luckyNumber, LottoNumber bonusNumber) {
        return new LuckyTicket(luckyNumber, bonusNumber);
    }

    public List<LottoNumber> getLuckyNumber() {
        return Collections.unmodifiableList(luckyNumber);
    }

    boolean checkBonusNumber(List<LottoNumber> lottoTicket) {
        return lottoTicket.contains(bonusNumber);
}
