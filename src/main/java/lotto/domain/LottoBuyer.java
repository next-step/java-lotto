package lotto.domain;

import lotto.dto.BuyData;

import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoBuyer {
    private int shouldBuyManualTicket;
    private int shouldBuyAutoticket;

    private LottoTicketBunch boughtManualTicketBunch;
    private LottoTicketBunch boughtAutoTicketBunch;

    public LottoBuyer(int shouldBuyManualTicket, int shouldBuyAutoticket) {
        this.shouldBuyManualTicket = shouldBuyManualTicket;
        this.shouldBuyAutoticket = shouldBuyAutoticket;

        boughtManualTicketBunch = new LottoTicketBunch();
        boughtAutoTicketBunch = new LottoTicketBunch();
    }

    public void buyManualTicketBunch(Supplier<String> manualNumbersSupplier) {
        boughtManualTicketBunch = boughtManualTicketBunch.merge(
            generateTicket(
                shouldBuyManualTicket,
                () -> LottoTicketGenerator.generateManualTicket(
                    manualNumbersSupplier.get()
                )
            )
        );
        shouldBuyManualTicket = 0;
    }

    public void buyAutoTicketBunch() {
        boughtAutoTicketBunch = boughtAutoTicketBunch.merge(
            generateTicket(
                shouldBuyAutoticket,
                LottoTicketGenerator::generateRandomTicket
            )
        );
        shouldBuyAutoticket = 0;
    }

    private LottoTicketBunch generateTicket(int ticketCnt, Supplier<LottoTicket> ticketSupplier) {
        return new LottoTicketBunch(
            IntStream.range(
                0, ticketCnt
            ).mapToObj(
                i -> ticketSupplier.get()
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
        return shouldBuyAutoticket == that.shouldBuyAutoticket;
    }

    @Override
    public int hashCode() {
        return Objects.hash(shouldBuyAutoticket);
    }
}
