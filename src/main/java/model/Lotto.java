package model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<Integer> lotto = new ArrayList<>();

    public Lotto(List<Integer> lotto) {
        LottoNumber lottoNumber = new LottoNumber(lotto);
        this.lotto = lottoNumber.getLottoNumber();
    }

    public List<Integer> getLotto() {
        return this.lotto;
    }

    public Boolean contains(int bonus) {
        if (lotto.contains(bonus)) {
            return true;
        }

        return false;
    }

}
