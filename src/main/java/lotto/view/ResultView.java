package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoList;
import lotto.domain.LottoStatistics;

import java.util.List;

public interface ResultView {
    void printLottoList(LottoList lottoList);

    void printLottoStatistics(LottoStatistics lottoStatistics);

    void printException(Exception e);
}
