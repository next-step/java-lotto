package lotto.view.output;

import lotto.domain.Lottos;
import lotto.domain.ResultStats;

public interface OutputViewInterface {

    void printPrompt(String prompt);

    void printTicketCount(int manualCount, int autoCount);

    void printLottos(Lottos lottos);

    void printResultStats(ResultStats resultStats, int totalSpent);
}
