package lotto.view.result;

import lotto.model.Place;
import lotto.model.dto.LottoStatisticsDto;
import lotto.view.View;
import lotto.view.result.statistic.PlaceView;
import lotto.view.result.statistic.ProfitView;

import java.util.ArrayList;
import java.util.List;

public class LottoStatisticsView implements View {
    private final List<PlaceView> places = new ArrayList<>();
    private final View comment;

    public LottoStatisticsView(LottoStatisticsDto statistics) {
        for (Place place : Place.winners()) {
            int count = statistics.count(place);
            PlaceView view = new PlaceView(place, count);
            places.add(view);
        }

        comment = new ProfitView(statistics.profit());
    }

    @Override
    public void render() {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        for (View place : places) {
            place.render();
        }

        comment.render();
    }
}
