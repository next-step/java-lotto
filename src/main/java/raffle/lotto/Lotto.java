package raffle.lotto;

import java.util.Comparator;
import java.util.List;

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
        return (int) lottoNumber.stream().filter(number -> lastWeekLotto.getLottoNumber().contains(number)).count();
    }

    public boolean hasBonus(Lotto bonusLotto) {
        return (int) lottoNumber.stream().filter(number -> bonusLotto.getLottoNumber().contains(number)).count() > 0;
    }

}
