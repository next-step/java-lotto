package lotto;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoMachine {

    public Lottos issue(int paidMoney) {
        int quantity = getPurchasableQuantity(paidMoney);

        return IntStream.range(0, quantity)
                .mapToObj(i -> new Lotto(new AutoLottoNumberSelectRule()))
                .collect(collectingAndThen(toList(), Lottos::new));
    }

    private int getPurchasableQuantity(int paidMoney) {
        if (paidMoney % Lotto.PRICE != 0) {
            throw new IllegalArgumentException("거슬러주지 않아도 되는 정확한 금액이어야 합니다.");
        }

        return paidMoney / Lotto.PRICE;
    }

}
