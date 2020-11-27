package lotto.views;

import java.util.ArrayList;
import java.util.List;
import lotto.Rank;
import lotto.TicketPublishType;
import lotto.dto.LottoResultDTO;
import lotto.dto.LottoTicketsDTO;
import lotto.dto.TicketPublisherDTO;

public class DataExporter {

  private LottoResultDTO lottoResultDTO;
  private LottoTicketsDTO lottoTicketsDTO;
  private TicketPublisherDTO ticketPublisherDTO;

  public DataExporter() {
  }

  public void setLottoResultDTO(LottoResultDTO lottoResultDTO) {
    this.lottoResultDTO = lottoResultDTO;
  }

  public void setLottoTicketsDTO(LottoTicketsDTO lottoTicketsDTO) {
    this.lottoTicketsDTO = lottoTicketsDTO;
  }

  public void setTicketPublisherDTO(TicketPublisherDTO ticketPublisherDTO) {
    this.ticketPublisherDTO = ticketPublisherDTO;
  }

  public List<ReportForm> exportStatisticReport() {
    List<ReportForm> statisticsReportForms = new ArrayList<>();

    for (Rank rank : Rank.values()) {
      int numHitCount = lottoResultDTO.getHitHistory().get(rank);
      boolean containsBonus = rank == Rank.SECOND;
      ReportForm report = new ReportForm(rank.getNumHit(), rank.getWinningReward(), containsBonus,
          numHitCount);
      statisticsReportForms.add(report);
    }
    return statisticsReportForms;
  }

  public List<String> exportTickets() {
    return this.lottoTicketsDTO.getTickets();
  }

  public int exportNumManualTicket() {
    return this.ticketPublisherDTO.publishingHistory.get(TicketPublishType.MANUAL);
  }

  public int exportNumAutoTicket() {
    return this.ticketPublisherDTO.publishingHistory.get(TicketPublishType.AUTO);
  }
}
