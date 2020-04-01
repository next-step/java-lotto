package step3.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuyLotto {
    private Set<LottoNumberList> buyLottoList;

    public BuyLotto(Lotto lotto, int totalCount) {
        Set<LottoNumberList> buyLottoList = new HashSet<>();
        for (int i = 0; i < totalCount; i++) {
            LottoNumberList lottoList = lotto.getRandomLottoList();
            buyLottoList.add(lottoList);
        }
        this.buyLottoList = buyLottoList;
    }


    public Set<LottoNumberList> getBuyLottoList() {
        return buyLottoList;
    }

    @Override
    public String toString() {
        return "BuyLotto{" +
                "buyLottoList=" + buyLottoList +
                '}';
    }
}
