package lotto.view;

import lotto.domain.LottoList;
import lotto.domain.LottoStatistics;


public interface ResultView {
    void printLottoList(LottoList lottoList);

    void printLottoStatistics(LottoStatistics lottoStatistics);

    void printException(Exception e);
}
