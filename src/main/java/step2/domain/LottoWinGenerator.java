package step2.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Boolean.FALSE;

public class LottoWinGenerator implements WinGenerator {

    private final List<Integer> winNumbers;

    public LottoWinGenerator(List<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }

    @Override
    public Prize winPrize(Lotto lotto) {
        List<Integer> resultNumber = new ArrayList<>();
        for (int number : lotto.getNumbers()) {
           if (winNumbers.contains(number)) {
               resultNumber.add(number);
           }
        }
        return new Prize(Rank.valueOf(resultNumber.size()));
    }

    public void addLottoNumber(int number, List<Integer> winLottoNumbers) {
        if (winNumbers.contains(number)) {
            winLottoNumbers.add(number);
        }
    }
}
