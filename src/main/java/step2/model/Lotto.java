package step2.model;

import java.util.*;

public class Lotto {
    public List<Integer> getNumbers(LottoStrategy lottoStrategy) {
        return lottoStrategy.getNumbers();
    }

    public List<List<Integer>> getLotto(int lottoCount) {
        List<List<Integer>> lottoList = new ArrayList<>();

        AutoLottoStrategy autoLottoStrategy = new AutoLottoStrategy();

        while (lottoCount-- > 0) {
            lottoList.add(getNumbers(autoLottoStrategy));
        }

        return lottoList;
    }
}
