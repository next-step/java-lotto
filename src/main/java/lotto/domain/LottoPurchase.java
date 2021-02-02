package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoPurchase implements Purchase {
    private static final String PURCHASE_INFORMATION_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final int LOTTO_TICKET_PRICE = 1_000;

    private final AutoNumbersPicker autoNumbersPicker;
    private final ManualNumbersPicker manualNumbersPicker;

    private final int purchaseAmount;
    private int purchaseManualCount = 0;
    private int purchaseAutoCount = 0;

    public LottoPurchase(final AutoNumbersPicker autoNumbersPicker, final ManualNumbersPicker manualNumbersPicker, final Money money) {
        this.manualNumbersPicker = manualNumbersPicker;
        this.autoNumbersPicker = autoNumbersPicker;
        this.purchaseAmount = money.getAmount();
        calculateLottoCount();
    }

    @Override
    public List<LottoTicket> buy() {
        Stream<LottoTicket> manualNumbersPickerStream = IntStream
                .range(0, purchaseManualCount)
                .mapToObj(i -> manualNumbersPicker.pick());

        Stream<LottoTicket> autoNumbersPickerStream = IntStream
                .range(0, purchaseAutoCount)
                .mapToObj(i -> autoNumbersPicker.pick());

        return Stream
                .concat(manualNumbersPickerStream, autoNumbersPickerStream)
                .collect(Collectors.toList());
    }

    @Override
    public int getAmount() {
        return purchaseAmount;
    }

    private void calculateLottoCount(){
        int purchaseTotalCount = purchaseAmount / LOTTO_TICKET_PRICE;
        purchaseManualCount = manualNumbersPicker.getSize();
        purchaseAutoCount = purchaseTotalCount - purchaseManualCount;
    }

    @Override
    public String toString() {
        return String.format(PURCHASE_INFORMATION_MESSAGE, purchaseManualCount, purchaseAutoCount);
    }
}