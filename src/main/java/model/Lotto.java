package model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> lotto = new ArrayList<>();

    public Lotto(List<Integer> lotto) {
        for (int num : lotto) {
            this.lotto.add(new LottoNumber(num).getLottoNumber());
        }
    }

    public List<Integer> getLotto() {
        return this.lotto;
    }

    public Boolean contains(int number) {
        return lotto.contains(number);
    }

}
