package view;

import domain.LottoResult;
import domain.Lottos;

public interface OutputWriter {

    void printLottosInfo(final Lottos lottos);

    void printLottoResultStatistic(final LottoResult lottoResult, final long money);
}
