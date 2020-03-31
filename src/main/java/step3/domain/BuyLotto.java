package step3.domain;

import java.util.List;
import java.util.Set;

public class BuyLotto {
    private Set<List<LottoNumber>> buyLottoList;

    public BuyLotto(Set<List<LottoNumber>> buyLottoList) {
        this.buyLottoList = buyLottoList;
    }

    public Set<List<LottoNumber>> getBuyLottoList() {
        return buyLottoList;
    }

}
