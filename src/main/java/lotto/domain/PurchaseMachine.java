package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author han
 */
public class PurchaseMachine {
    private final Credit credit;
    private final List<Lotto> lottoList;
    private final Statistics statistics;

    private PurchaseMachine(Credit credit, List<Lotto> lottoList, Statistics statistics) {
        this.credit = credit;
        this.lottoList = lottoList;
        this.statistics = statistics;
    }

    public PurchaseMachine(Credit credit, List<Lotto> lottoList) {
        this.credit = credit;
        this.lottoList = lottoList;
        this.statistics = null;
    }

    public PurchaseMachine(Credit credit) {
        this.credit = credit;
        this.lottoList = Collections.emptyList();
        this.statistics = null;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public PurchaseMachine purchase() {
        int count = this.credit.getLottoCount();
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.createByAuto());
        }
        return new PurchaseMachine(this.credit, lottos);
    }

    public PurchaseMachine insertWonLotto(Lotto won) {
        Statistics statistics = new Statistics(this.credit, won, this.lottoList);
        return new PurchaseMachine(this.credit, this.lottoList, statistics);
    }
}
