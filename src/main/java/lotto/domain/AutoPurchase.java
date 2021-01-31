package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * LottoTicket을 자동으로 구입하는 전략
 */
public class AutoPurchase implements LottoPurchase {

    @Override
    public List<LottoTicket> purchase(final PurchaseAmount amount) {
        int count = amount.getCount();
        return IntStream
                .range(0, count)
                .mapToObj(i -> new LottoTicket(LottoNumbersPicker.pick()))
                .collect(Collectors.toList());
    }
}
