package io.mwkwon.lotto.domain;

import io.mwkwon.lotto.constant.LottoConstants;
import io.mwkwon.lotto.interfaces.LottoGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine implements LottoGenerator {
    private static final List<LottoNumber> LOTTO_NUMBERS = new ArrayList<>();

    static {
        for (int i = LottoConstants.MIN_LOTTO_NUMBER; i <= LottoConstants.MAX_LOTTO_NUMBER; i++) {
            LOTTO_NUMBERS.add(LottoNumber.create(i));
        }
    }

    @Override
    public BuyLottos createAutoLottos(LottoPayment lottoPayment) {
        List<Lotto> lottos = new ArrayList<>();
        int lottoBuyQuantity = lottoPayment.calcLottoBuyQuantity();
        for (int i = 0; i < lottoBuyQuantity; i++) {
            Collections.shuffle(LOTTO_NUMBERS);
            lottos.add(Lotto.create(LOTTO_NUMBERS.subList(LottoConstants.FROM_INDEX, LottoConstants.LOTTO_BOUND)));
        }
        return new BuyLottos(lottos);
    }
}
