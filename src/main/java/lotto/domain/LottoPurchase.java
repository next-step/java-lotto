package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoPurchase implements Purchase {
    private static final String PURCHASE_INFORMATION_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";

    private final AutoNumbersPicker autoNumbersPicker;
    private final ManualNumbersPicker manualNumbersPicker;
    private final LottoCount lottoCount;

    public LottoPurchase(final AutoNumbersPicker autoNumbersPicker, final ManualNumbersPicker manualNumbersPicker, final LottoCount lottoCount) {
        this.manualNumbersPicker = manualNumbersPicker;
        this.autoNumbersPicker = autoNumbersPicker;
        this.lottoCount = lottoCount;
    }

    @Override
    public List<LottoTicket> buy() {
        final Stream<LottoTicket> manualNumbersPickerStream = IntStream
                .range(0, lottoCount.getManualLottoCount())
                .mapToObj(i -> manualNumbersPicker.pick());

        final Stream<LottoTicket> autoNumbersPickerStream = IntStream
                .range(0, lottoCount.getAutoLottoCount())
                .mapToObj(i -> autoNumbersPicker.pick());

        return Stream
                .concat(manualNumbersPickerStream, autoNumbersPickerStream)
                .collect(Collectors.toList());
    }

    @Override
    public int getAmount() {
        return lottoCount.getTotalAmount();
    }

    @Override
    public String toString() {
        return String.format(
                PURCHASE_INFORMATION_MESSAGE,
                lottoCount.getManualLottoCount(),
                lottoCount.getAutoLottoCount()
        );
    }
}