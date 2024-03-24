package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        Validator.validateLotto(lotto);
        this.lotto = lotto;
    }

    public Lotto(String lotto) {
        this.lotto = Validator.parseLottoNumbers(lotto);
    }

    public String toString() {
        return lotto.toString();
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}
