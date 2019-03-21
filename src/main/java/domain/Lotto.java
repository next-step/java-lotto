package domain;

import java.util.List;

public class Lotto {
    private List<Integer> lotto;

    public Lotto(List<Integer> lottoNumber) {
        this.lotto = lottoNumber;
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}
