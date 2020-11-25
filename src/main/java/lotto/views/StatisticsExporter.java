package lotto.views;

import java.util.ArrayList;
import java.util.List;
import lotto.Rank;
import lotto.dto.LottoResultDTO;

public class StatisticsExporter {

  List<ReportForm> reportForms;

  public StatisticsExporter(LottoResultDTO dto) {
    reportForms = new ArrayList<>();

    for (Rank rank : Rank.values()) {
      int numHitCount = dto.getHitHistory().get(rank);
      boolean containsBonus = rank == Rank.SECOND;
      ReportForm report = new ReportForm(rank.getNumHit(), rank.getWinningReward(), containsBonus,
          numHitCount);
      reportForms.add(report);
    }
  }

  public List<ReportForm> publishReport() {
    return this.reportForms;
  }
}
