package lotto;


import lotto.model.Lottos;
import lotto.service.LottoNumberPicker;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;

    private final LottoNumberPicker lottoNumberPicker;

    public LottoStore(LottoNumberPicker lottoNumberPicker) {
        this.lottoNumberPicker = lottoNumberPicker;
    }

    public Lottos buy(int money){
        return new Lottos(getLottoNum(money),lottoNumberPicker);
    };
    private int getLottoNum(int input) {
        return input / LOTTO_PRICE;
    }

}
