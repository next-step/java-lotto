package step3.domain;

import java.util.List;
import java.util.Set;

public class BuyLotto {
    public BuyLotto(Set<List<Integer>> buyLottoList) {
        this.buyLottoList = buyLottoList;
    }

    public Set<List<Integer>> getBuyLottoList() {
        return buyLottoList;
    }

    private Set<List<Integer>> buyLottoList;
}
