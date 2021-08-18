package lotto.domain;

import lotto.exception.InputError;

import java.util.ArrayList;
import java.util.List;

public class LottoCreator {

    private static final int LOTTO_PRICE = 1000;

    private final int lottoCount;

    public LottoCreator(final int money) {
        this.lottoCount = money / LOTTO_PRICE;
        if (lottoCount <= 0) {
            throw new InputError("로또를 구매할 수 없는 금액입니다.");
        }
    }

    public List<LottoNumbers> createLottos(LottoNumbersCreator numberCreator) {
        List<LottoNumbers> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(numberCreator.createLottoNumbers());
        }
        return lottos;
    }
}
