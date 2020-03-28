package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public static final Integer COUNT_NUMBER = 6;
    private final List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        this.lotto = new ArrayList<>(lotto);
    }

    public List<LottoNumber> getValue() {
        return new ArrayList<>(lotto);
    }
}
