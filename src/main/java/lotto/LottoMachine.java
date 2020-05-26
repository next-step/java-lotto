package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    public Lottos issue(int paidMoney) {
        int quantity = getPurchasableQuantity(paidMoney);

        List<Lotto> lottos = IntStream.range(0, quantity)
                .mapToObj(i -> new Lotto(new AutoLottoNumberSelectRule()))
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    private int getPurchasableQuantity(int paidMoney) {
        if (paidMoney % Lotto.PRICE != 0) {
            throw new IllegalArgumentException("거슬러주지 않아도 되는 정확한 금액이어야 합니다.");
        }

        return paidMoney / Lotto.PRICE;
    }

}
