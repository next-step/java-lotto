package lotto.view;

import lotto.domain.LottoList;
import lotto.domain.LottoStatistics;


public interface ResultView {
    void printLottoList(LottoList lottoList, int manualLottoSize);

    void printLottoStatistics(LottoStatistics lottoStatistics);

    void printException(Exception e);
}
