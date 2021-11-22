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
    private final Lotto won;

    private PurchaseMachine(Credit credit, List<Lotto> lottoList, Lotto won) {
        this.credit = credit;
        this.lottoList = lottoList;
        this.won = won;
    }

    public PurchaseMachine(Credit credit, List<Lotto> lottoList) {
        this.credit = credit;
        this.lottoList = lottoList;
        this.won = Lotto.createByAuto();
    }

    public PurchaseMachine(Credit credit) {
        this.credit = credit;
        this.lottoList = Collections.emptyList();
        this.won = Lotto.createByAuto();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public Lotto getWon() {
        return won;
    }

    public PurchaseMachine purchase() {
        int count = credit.getNumber();
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.createByAuto());
        }
        return new PurchaseMachine(credit, lottos);
    }

    public PurchaseMachine insertWonLotto(Lotto won) {
        return new PurchaseMachine(this.credit, this.lottoList, won);
    }
}
