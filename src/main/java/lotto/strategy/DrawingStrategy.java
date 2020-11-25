package lotto.strategy;

import lotto.model.lotto.LottoTicket;

public interface DrawingStrategy {
    int NUMBER_COUNT = 6;
    int THRESHOLD = 45;

    LottoTicket drawNumbers();

}
