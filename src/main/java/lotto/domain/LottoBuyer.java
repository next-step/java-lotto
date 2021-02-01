package lotto.domain;

import lotto.dto.BuyData;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoBuyer {
    private int manualTicketCnt;
    private int autoTicketCnt;

    private List<LottoTicket> boughtManualTickets;
    private List<LottoTicket> boughtAutoTickets;

    public LottoBuyer(int autoTicketCnt, int manualTicketCnt) {
        this.manualTicketCnt = manualTicketCnt;
        this.autoTicketCnt = autoTicketCnt;

        boughtManualTickets = new ArrayList<>();
        boughtAutoTickets = new ArrayList<>();
    }

    public boolean shouldBuyManualTicket() {
        return manualTicketCnt - boughtManualTickets.size() > 0;
    }

    public void buyManualTicket(String manualNumbers) {
        boughtManualTickets.add(
            LottoTicketGenerator.generateManualTicket(manualNumbers)
        );
    }

    public void buyAutoTickets() {
        IntStream.range(
            0, autoTicketCnt
        ).forEach(
            i -> boughtAutoTickets.add(
                LottoTicketGenerator.generateRandomTicket()
            )
        );
    }

    private Stream<LottoTicket> getBoughtTicketsStream() {
        return Stream.concat(
            boughtManualTickets.stream(),
            boughtAutoTickets.stream()
        );
    }

    public LottoTicketBunch getBoughtTickets() {
        return new LottoTicketBunch(
            getBoughtTicketsStream().collect(
                Collectors.toList()
            )
        );
    }

    public BuyData getBuyData() {
        return new BuyData(
            boughtAutoTickets.size(),
            boughtManualTickets.size(),
            getBoughtTicketsStream().map(
                ticket -> ticket.getTicketData()
            ).collect(
                Collectors.toList()
            )
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
