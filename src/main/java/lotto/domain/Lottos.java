package lotto.domain;

import lotto.exception.InputError;

import java.util.List;

public class Lottos {
    private final List<LottoNumbers> lottos;

    public Lottos(final List<LottoNumbers> lottos) {
        if (lottos == null || lottos.size() == 0) {
            throw new InputError("구매한 로또가 없습니다.");
        }
        this.lottos = lottos;
    }

    public List<LottoNumbers> value() {
        return lottos;
    }
}
