package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoPurchase implements Purchase {
    private static final int LOTTO_TICKET_PRICE = 1_000;
    private final NumberPicker numberPicker;
    private final int purchaseAmount;

    public LottoPurchase(final NumberPicker numberPicker, final int purchaseAmount) {
        this.numberPicker = numberPicker;
        this.purchaseAmount = purchaseAmount;
    }

    @Override
    public List<LottoTicket> buy() {
        int purchaseCount = purchaseAmount / LOTTO_TICKET_PRICE;
        return IntStream
                .range(0, purchaseCount)
                .mapToObj(i -> new LottoTicket(numberPicker.pick()))
                .collect(Collectors.toList());
    }

    @Override
    public int getAmount() {
        return purchaseAmount;
    }
}