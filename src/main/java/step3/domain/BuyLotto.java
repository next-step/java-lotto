package step3.domain;

import java.util.List;
import java.util.Set;

public class BuyLotto {
    private Set<List<Integer>> buyLottoList;

    public BuyLotto(Set<List<Integer>> buyLottoList) {
        this.buyLottoList = buyLottoList;
    }

    public Set<List<Integer>> getBuyLottoList() {
        return buyLottoList;
    }

}
