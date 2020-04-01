package step3.domain;

import java.util.ArrayList;
import java.util.List;

public class BuyLotto {
    private List<LottoNumberList> buyLottoList;

    public BuyLotto(Lotto lotto, int totalCount) {
        List<LottoNumberList> buyLottoList = new ArrayList<>();
        for (int i = 0; i < totalCount; i++) {
            LottoNumberList lottoList = lotto.getRandomLottoList();
            buyLottoList.add(lottoList);
        }
        this.buyLottoList = buyLottoList;
    }

    public List<LottoNumberList> getBuyLottoList() {
        return buyLottoList;
    }
}
