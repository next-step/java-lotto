package raffle.lotto;

import java.util.Comparator;
import java.util.List;

import static raffle.lotto.LottoMachine.LOTTO_MAX;
import static raffle.lotto.LottoMachine.LOTTO_MAX_NUMBER;
import static raffle.lotto.LottoMachine.LOTTO_MIN_NUMBER;

public class Lotto {

    private List<Integer> lottoNumber;

    public Lotto(List<Integer> lottoNumber) {
        this.lottoNumber = lottoNumber;
        lottoNumber.sort(Comparator.naturalOrder());
    }

    public List<Integer> getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumber.toArray());
    }

    public int getWinCount(Lotto lastWeekLotto) {
        return (int) lottoNumber.stream().filter(number -> lastWeekLotto.contains(number)).count();
    }

    private boolean contains(Integer number) {
        return lottoNumber.contains(number);
    }

    public boolean hasBonus(LottoNo bonusLotto) {
        return (int) lottoNumber.stream().filter(number -> number.equals(bonusLotto.getBonusnumber())).count() > 0;
    }

}
