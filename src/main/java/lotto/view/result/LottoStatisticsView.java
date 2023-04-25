package lotto.view.result;

import lotto.model.Place;
import lotto.model.dto.LottoStatisticsDto;
import lotto.view.View;

public class LottoStatisticsView implements View {
    private static final String MATCH_FORMAT = "%d개 일치 (%d원)- %d개\n";
    private static final String PROFIT_FORMAT = "총 수익률은 %.2f입니다.";

    private final LottoStatisticsDto statistics;

    public LottoStatisticsView(LottoStatisticsDto statistics) {
        this.statistics = statistics;
    }

    @Override
    public void render() {
        System.out.println("\n당첨 통계");
        System.out.println("---------");
        for (Place place : Place.winners()) {
            System.out.printf(MATCH_FORMAT, place.matches(), place.reward(), statistics.count(place));
        }

        float profit = statistics.profit();
        System.out.println(profitComment(profit));
    }


    private String profitComment(float profit) {
        String additional = profit < 1 ? "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" : "";
        return String.format(PROFIT_FORMAT, profit) + additional;
    }
}
