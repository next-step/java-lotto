package raffle.domain.lotto;

import java.util.Arrays;
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
        return Arrays.toString(lottoNumber.toArray());
    }

    public int getWinCount(List<LottoNo> lastWeekLotto) {
        return (int) lottoNumber.stream().filter(lottoNo -> lottoNo.isLottoNumber(lastWeekLotto)).count();
    }

    public boolean hasBonus(LottoNo bonusLotto) {
        return (int) lottoNumber.stream().filter(lottoNo -> lottoNo.equals(bonusLotto)).count() > 0;
    }

}
