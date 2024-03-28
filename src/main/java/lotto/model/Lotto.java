package lotto.model;

import java.util.List;

public class Lotto {
    private final List<Integer> lottoNumber;

    public Lotto(List<Integer> lotto) {
        Validator.validateLotto(lotto);
        this.lottoNumber = lotto;
    }

    public Lotto(String lotto) {
        this.lottoNumber = Validator.parseLottoNumbers(lotto);
    }

    public String toString() {
        return lottoNumber.toString();
    }

    public List<Integer> getLotto() {
        return lottoNumber;
    }
}
