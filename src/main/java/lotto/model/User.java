package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<Lotto> lottos;

    public User(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public List<Lotto> findEachLottoMatchingNumber(WinningNumber winningNumber) {
        for (Lotto lotto : lottos) {
            lotto.matchLottoWithWinningNumber(winningNumber);
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

}
