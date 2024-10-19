package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoBuyer {
    private List<Integer>[] lottos;

    public LottoBuyer(int buyLottoCount) {
        this.lottos = new ArrayList[buyLottoCount];
    }

    public void saveLotto(int count, List<Integer> lotto) {
        this.lottos[count] = lotto;
    }

    public List<Integer>[] giveLottos() {
        return lottos;
    }
}
