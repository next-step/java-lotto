package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumber {

    private List<Integer> lotto;

    public LottoNumber() {
        lotto = new ArrayList<>();
    }

    public void setLotto(RandomNumber lottoNumberStragey) {
        this.lotto = lottoNumberStragey.getLottoNumber();
    }

    public List<Integer> getLotto() {
        return this.lotto;
    }

}
