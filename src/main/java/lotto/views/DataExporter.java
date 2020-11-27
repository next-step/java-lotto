package lotto.views;

import java.util.ArrayList;
import java.util.List;
import lotto.Rank;
import lotto.dto.LottoResultDTO;
import lotto.dto.LottoTicketsDTO;

public class DataExporter {

  private LottoResultDTO lottoResultDTO;
  private LottoTicketsDTO lottoTicketsDTO;

  public DataExporter() {
  }

  public void setLottoResultDTO(LottoResultDTO lottoResultDTO) {
    this.lottoResultDTO = lottoResultDTO;
  }

  public void setLottoTicketsDTO(LottoTicketsDTO lottoTicketsDTO) {
    this.lottoTicketsDTO = lottoTicketsDTO;
  }

  public List<ReportForm> publishStatisticReport() {
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
}
