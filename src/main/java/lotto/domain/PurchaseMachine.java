package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author han
 */
public class PurchaseMachine {
    private final Credit credit;
    private final List<Lotto> lotto;

    private PurchaseMachine(Credit credit, List<Lotto> lottoList) {
        this.credit = credit;
        this.lotto = lottoList;
    }

    public PurchaseMachine(Credit credit) {
        this.credit = credit;
        this.lotto = Collections.emptyList();
    }

    public List<Lotto> getLotto() {
        return lotto;
    }

    public PurchaseMachine purchase() {
        int count = this.credit.getLottoCount();

        List<Lotto> lottos = IntStream.range(0, count)
            .mapToObj(i -> Lotto.createByAuto())
            .collect(Collectors.toList());

        return new PurchaseMachine(this.credit, lottos);
    }
}
