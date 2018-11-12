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
        return (int) lottoNumber.stream().filter(lottoNo -> matching(lottoNo, lastWeekLotto)).count();
    }

    private boolean matching(LottoNo lottoNumber, Lotto lastWeekLotto) {
        return lastWeekLotto.getLottoNumber().stream().anyMatch(lottoNo -> lottoNo.isLotto(lottoNumber));
    }

    public boolean hasBonus(LottoNo bonusLotto) {
        return (int) lottoNumber.stream().filter(lottoNo -> bonusLotto.isLotto(lottoNo)).count() > 0;
    }

}
