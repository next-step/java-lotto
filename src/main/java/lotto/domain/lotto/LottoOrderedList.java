package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.shop.Order;

public class LottoOrderedList {
    private final List<Lotto> lottoList;

    public LottoOrderedList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public LottoOrderedList(Order order) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < order.getOrderedLottoCount(); i++) {
            lottoList.add(order.getLotto(i));
        }
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getLottoOrderedCount() {
        return lottoList.size();
    }

}
