package lotto.models;

import lotto.models.request.LottoNumberRequest;

import java.util.List;

public class IssuedLotto {

    public static final int PRICE = 1000;
    private final Lotto lotto;

    private IssuedLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public static IssuedLotto from(LottoNumberRequest lottoNumberRequest) {
        return new IssuedLotto(Lotto.of(lottoNumberRequest.getNumber()));
    }

    public static IssuedLotto of(List<Integer> lottoNumbers) {
        return new IssuedLotto(Lotto.of(lottoNumbers));
    }


}
