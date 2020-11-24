package lotto.views;

public class TicketsExporter {

  ReadOnlyLottoTickets lottoTickets;

  public TicketsExporter(ReadOnlyLottoTickets lottoTickets) {
    this.lottoTickets = lottoTickets;
  }

  public int getNumTicket() {
    return this.lottoTickets.getNumTicket();
  }

  public String getTicket(int idx) {
    return this.lottoTickets.getTicket(idx);
  }
}
