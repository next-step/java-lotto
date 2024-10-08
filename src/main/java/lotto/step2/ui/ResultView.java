package lotto.step2.ui;

import jdk.swing.interop.SwingInterOpUtils;
import lotto.step2.domain.*;

import java.util.Arrays;
import java.util.EnumMap;

public interface ResultView {
    void showLottoCount(int count);
    void showLottos(Lottos lottos);
    void showLottoResult(EnumMap<LottoRank, Integer> rankInfo);
    void showLottoProfit(double profitRate);
    void showProfitStatus(ProfitStatus status);
}
