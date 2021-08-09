package step2.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public List<Integer> getNumbers(LottoStrategy lottoStrategy) {
        return lottoStrategy.getNumbers();
    }

    public List<List<Integer>> getLotto(int cnt) {
        List<List<Integer>> lottoList = new ArrayList<>();

        while (cnt-- > 0) {
            lottoList.add(getNumbers(new AutoLottoStrategy()));
        }

        return lottoList;
    }
}
