package lotto.numberdrawer;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffledNumberDrawer implements NumberDrawer{
    @Override
    public List<LottoNumber> drawnNumbers(int bound, int size) {
        List<LottoNumber> result = new ArrayList<>();
        for (int i = 1; i <= bound; i++) {
            result.add(LottoNumber.valueOf(i));
        }

        Collections.shuffle(result);

        return result.subList(0, size);
    }
}
