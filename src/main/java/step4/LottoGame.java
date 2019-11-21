package step4;

import step4.generator.LottoGenerator;
import step4.model.Lotto;
import step4.model.LottoNumber;
import step4.model.LottoResult;
import step4.model.Rank;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final List<Lotto> lottos;
    private final int money;

    public LottoGame(LottoGenerator generator, int money) {
        this.lottos = generator.generate(money);
        this.money = money;
    }

    public LottoGame(List<Lotto> lottos, int money) {
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
