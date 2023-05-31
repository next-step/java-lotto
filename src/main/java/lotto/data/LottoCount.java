package lotto.data;

import static lotto.data.Lotto.LOTTO_PRICE;

public class LottoCount {
    private int count;

    public LottoCount(int count){
        this.count = count;
    }

    public static LottoCount of(int price){
        return new LottoCount(price / LOTTO_PRICE);
    }

    public int getCount(){
        return this.count;
    }
}
