package lotto.domain;

import lotto.dto.BuyData;

import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBuyer {
    private int manualTicketCnt;
    private int autoTicketCnt;

    private LottoTicketBunch boughtManualTicketBunch;
    private LottoTicketBunch boughtAutoTicketBunch;

    public LottoBuyer(int manualTicketCnt, int autoTicketCnt) {
        this.manualTicketCnt = manualTicketCnt;
        this.autoTicketCnt = autoTicketCnt;

        boughtManualTicketBunch = new LottoTicketBunch();
        boughtAutoTicketBunch = new LottoTicketBunch();
    }

    public void buyManualTicketBunch(Supplier<String> manualNumbersSupplier) {
        boughtManualTicketBunch = new LottoTicketBunch(
            IntStream.range(
                0, manualTicketCnt
            ).mapToObj(
                i -> LottoTicketGenerator.generateManualTicket(
                    manualNumbersSupplier.get()
                )
            ).collect(
                Collectors.toList()
            )
        );
    }

    public void buyAutoTicketBunch() {
        boughtAutoTicketBunch = new LottoTicketBunch(
            IntStream.range(
                0, autoTicketCnt
            ).mapToObj(
                i -> LottoTicketGenerator.generateRandomTicket()
            ).collect(
                Collectors.toList()
            )
        );
    }

    public LottoTicketBunch getBoughtTicketBunch() {
        return boughtManualTicketBunch.merge(
            boughtAutoTicketBunch
        );
    }

    public BuyData getBuyData() {
        return new BuyData(
            boughtAutoTicketBunch.getSize(),
            boughtManualTicketBunch.getSize(),
            getBoughtTicketBunch().getTicketsData()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoBuyer that = (LottoBuyer) o;
        return autoTicketCnt == that.autoTicketCnt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoTicketCnt);
    }
}
