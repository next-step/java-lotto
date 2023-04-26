package lotto.control.output;

import lotto.model.dto.LottoStatisticsDto;
import lotto.view.View;
import lotto.view.result.LottoStatisticsView;

public class LottoStatisticsOutput implements Printable {
    private final LottoStatisticsDto statistics;

    public LottoStatisticsOutput(LottoStatisticsDto statistics) {
        this.statistics = statistics;
    }

    @Override
    public void print() {
        View view = new LottoStatisticsView(statistics);
        view.render();
    }
}
