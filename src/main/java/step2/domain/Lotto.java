package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public static final Integer COUNT_NUMBER = 6;
    private final List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        //TODO: 중복된 값이 들어오는 지 검증
        this.lotto = new ArrayList<>(lotto);
    }

    public List<LottoNumber> getValue() {
        return new ArrayList<>(lotto);
    }
}
