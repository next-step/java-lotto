package lotto.domain;

import calculator.PositiveNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author han
 */
public class PurchaseMachine {
    private final static int price = 1000;
    private final PositiveNumber credit;
    private final List<Lotto> lottoList;
    private final Lotto won;

    private PurchaseMachine(PositiveNumber credit, List<Lotto> lottoList, Lotto won) {
        this.credit = credit;
        this.lottoList = lottoList;
        this.won = won;
    }

    public PurchaseMachine(PositiveNumber credit, List<Lotto> lottoList) {
        this.credit = credit;
        this.lottoList = lottoList;
        this.won = Lotto.createByAuto();
    }

    public PurchaseMachine(PositiveNumber credit) {
        this.credit = credit;
        this.lottoList = Collections.emptyList();
        this.won = Lotto.createByAuto();
    }

    public PositiveNumber getCredit() {
        return credit;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public Lotto getWon() {
        return won;
    }

    public PurchaseMachine purchase() {
        int count = credit.getNumber() / price;
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
