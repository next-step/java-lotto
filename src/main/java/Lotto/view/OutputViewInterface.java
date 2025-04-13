package Lotto.view;

import Lotto.domain.Lottos;
import Lotto.domain.ResultStats;

public interface OutputViewInterface {
    void printPrompt(String prompt);

    void printTicketCount(int manualCount, int autoCount);

    void printLottos(Lottos lottos);

//    void printSummary(ResultStats summary);
}
