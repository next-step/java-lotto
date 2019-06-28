package step4.domain;

import java.util.Collections;
import java.util.List;

public class LuckyTicket {
    private final List<LottoNumber> luckyNumber;
    private final LottoNumber bonusNumber;

    public LuckyTicket(List<LottoNumber> luckyNumber, LottoNumber bonusNumber) {
        this.luckyNumber = luckyNumber;
        this.bonusNumber = bonusNumber;
    }

    public static LuckyTicket of(List<LottoNumber> luckyNumber, LottoNumber bonusNumber) {
        return new LuckyTicket(luckyNumber, bonusNumber);
    }

    public List<LottoNumber> getLuckyNumber() {
        return Collections.unmodifiableList(luckyNumber);
    }

    public boolean checkBonusNumber(List<LottoNumber> lottoTicket) {
        return lottoTicket.contains(bonusNumber);
    }
}
