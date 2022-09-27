package lotto;


import lotto.service.LottoNumberPicker;

import java.util.List;

public class LottoStore {

    private final int LOTTO_PRICE = 1000;

    private final LottoNumberPicker lottoNumberPicker;

    public LottoStore(LottoNumberPicker lottoNumberPicker) {
        this.lottoNumberPicker = lottoNumberPicker;
    }

    public Lottos buy(int money){
        return new Lottos(getLottoNum(money),lottoNumberPicker);
    };
    public int getLottoNum(int input) {
        return input / LOTTO_PRICE;
    }

}