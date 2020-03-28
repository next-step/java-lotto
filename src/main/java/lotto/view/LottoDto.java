package lotto.view;

import lotto.domain.item.LottoTicket;

import java.util.List;

public class LottoDto {
    private List<LottoTicket> tickets;
    private int match3GameCount = 0;
    private int match4GameCount = 0;
    private int match5GameCount = 0;
    private int match6GameCount = 0;

    public List<LottoTicket> getTickets() {
        return tickets;
    }

    public int getMatch3GameCount() {
        return match3GameCount;
    }

    public int getMatch4GameCount() {
        return match4GameCount;
    }

    public int getMatch5GameCount() {
        return match5GameCount;
    }

    public int getMatch6GameCount() {
        return match6GameCount;
    }

    public void setTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public void setMatch3GameCount(int match3GameCount) {
        this.match3GameCount = match3GameCount;
    }

    public void setMatch4GameCount(int match4GameCount) {
        this.match4GameCount = match4GameCount;
    }

    public void setMatch5GameCount(int match5GameCount) {
        this.match5GameCount = match5GameCount;
    }

    public void setMatch6GameCount(int match6GameCount) {
        this.match6GameCount = match6GameCount;
    }
}
