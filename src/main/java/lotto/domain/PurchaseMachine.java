package lotto.domain;

import calculator.PositiveNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * @author han
 */
public class PurchaseMachine {
    private final static int price = 1000;
    private final PositiveNumber credit;
    private final List<Lotto> lottoList;

    public PurchaseMachine(PositiveNumber credit, List<Lotto> lottoList) {
        this.credit = credit;
        this.lottoList = lottoList;
    }

    public PositiveNumber getCredit() {
        return credit;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public PurchaseMachine purchase() {
        int count = credit.getNumber() / price;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i ++) {
            lottos.add(Lotto.createByAuto());
        }
        return new PurchaseMachine(credit, lottos);
    }
}
