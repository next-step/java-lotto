package raffle.lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<LottoNo> lottoNumber;

    public Lotto(List<LottoNo> lottoNumber) {
        this.lottoNumber = lottoNumber;
        Collections.sort(lottoNumber);
    }

    public List<LottoNo> getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber.toArray());
    }

    public int getWinCount(Lotto lastWeekLotto) {
        return (int) lottoNumber.stream().filter(lottoNo -> matching(lottoNo.getLottoNumber(), lastWeekLotto.getLottoNumber())).count();
    }

    private boolean matching(int lottoNumber, List<LottoNo> lastWeekLotto) {
        return lastWeekLotto.stream().anyMatch(lottoNo -> lottoNo.getLottoNumber() == lottoNumber);
    }

    private boolean isaBoolean(int lottoNumber, LottoNo lottoNo) {
        return lottoNo.getLottoNumber() == lottoNumber;
    }

    public boolean hasBonus(LottoNo bonusLotto) {
        return (int) lottoNumber.stream().filter(lottoNo -> isaBoolean(bonusLotto.getLottoNumber(), lottoNo)).count() > 0;
    }

}
