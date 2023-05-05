package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private List<LottoNumber> lotto;

    public Lotto(List<Integer> numbers) {
        List<LottoNumber> lotto = new ArrayList<>();
        for (Integer number : numbers) {
            lotto.add(LottoNumber.of(number));
        }
        this.lotto = lotto;
    }

    public List<LottoNumber> getLotto(){
        return lotto;
    }

    int countEqualNumbers(Lotto winningNumbers) {
        return (int) lotto.stream()
            .filter(winningNumbers::contain)
            .count();
    }

    private boolean contain(LottoNumber otherLottoNumber) {
        return lotto.stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(otherLottoNumber));
    }

}
