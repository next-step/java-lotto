package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Prizes judge(WinningLotto winningLotto) {
        List<Prize> prizes = new ArrayList<>();
        for (Lotto lotto : lottos) {
            prizes.add(lotto.judge(winningLotto));
        }
        return new Prizes(prizes);
    }

    public List<Lotto> value() {
        return lottos;
    }

    public int size() {
        return lottos.size();
    }

    public int price() {
        return Lotto.FIXED_BALL_AMOUNT * size();
    }
}
