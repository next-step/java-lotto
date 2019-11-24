package step4;

import step4.generator.LottoGenerator;
import step4.model.*;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final List<Lotto> lottos;
    private final Money money;

    public LottoGame(LottoGenerator generator, Money money) {
        this.lottos = generator.generate(money);
        this.money = money;
    }

    public LottoGame(List<Lotto> lottos, Money money) {
        this.lottos = lottos;
        this.money = money;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public LottoResult getResult(Lotto winLotto, LottoNumber bonusNumber) {
        if (winLotto.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            addRank(ranks, lotto.getRank(winLotto, bonusNumber));
        }

        return new LottoResult(ranks, money);
    }

    private void addRank(List<Rank> ranks, Rank rank) {
        if (rank != Rank.MISS) {
            ranks.add(rank);
        }
    }
}
