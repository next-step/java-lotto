package lotto;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoMachine {

    public Lottos issue(LottoIssueRequest request) {
        int quantity = getPurchasableQuantity(request.getPaidMoney());

        return IntStream.range(0, quantity)
                .mapToObj(i -> new Lotto(new AutoLottoNumberSelectRule()))
                .collect(collectingAndThen(toList(), Lottos::new));
    }

    private int getPurchasableQuantity(int paidMoney) {
        return paidMoney / Lotto.PRICE;
    }
}
