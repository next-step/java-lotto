package lotto.ui.output;

import lotto.model.Lottos;
import lotto.model.Statistics;

public interface OutputView {
    void printLotto(Lottos lottos);
    void printStatistics(Statistics statistics);
}
