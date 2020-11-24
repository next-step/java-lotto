package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoStore {


    public List<Lotto> buy(int fee) {
        if (isEnougisNotEnoughFeehFee(fee)){
            throw new IllegalArgumentException("금액이 충분하지 않습니다.");
        }

        int buyCount = getBuyCount(fee);

        List<Lotto> boughtLotto = new ArrayList<>();
        for (int count = 0; count < buyCount; count++) {
            boughtLotto.add(new Lotto());
        }
        return boughtLotto;
    }

    private int getBuyCount(int fee) {
        return fee/1000;
    }

    private boolean isEnougisNotEnoughFeehFee(int fee) {
        return fee < 1000;
    }
}
