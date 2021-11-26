package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author han
 */
public class PurchaseMachine {
    private final Credit credit;

    public PurchaseMachine(Credit credit) {
        this.credit = credit;
    }

    public List<Lotto> purchase() {
        int count = this.credit.getLottoCount();

        List<Lotto> lottos = IntStream.range(0, count)
            .mapToObj(i -> new Lotto(LottoNumber.createNonDuplicated()))
            .collect(Collectors.toList());

        return lottos;
    }
}
