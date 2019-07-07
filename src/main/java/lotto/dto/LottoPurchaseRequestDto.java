package lotto.dto;

import lotto.common.Csv;
import lotto.common.PositiveNumber;
import sun.jvm.hotspot.runtime.posix.POSIXSignals;

import java.util.List;

public class LottoPurchaseRequestDto {
    private PositiveNumber purchaseAmount;
    private List<Csv> manualTicketNumbers;

    private LottoPurchaseRequestDto(PositiveNumber purchaseAmount, List<Csv> manualTicketNumbers) {
        this.purchaseAmount = purchaseAmount;
        this.manualTicketNumbers = manualTicketNumbers;
    }

    public static LottoPurchaseRequestDto of(PositiveNumber purchaseAmount, List<Csv> manualTicketNumbers) {
        return new LottoPurchaseRequestDto(purchaseAmount, manualTicketNumbers);
    }

    public PositiveNumber getPurchaseAmount() {
        return purchaseAmount;
    }

    public List<Csv> getManualTicketNumbers() {
        return manualTicketNumbers;
    }

    public PositiveNumber getManualTicketCount() {
        return PositiveNumber.of(manualTicketNumbers.size());
    }
}
