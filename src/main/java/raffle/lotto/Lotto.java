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
}
