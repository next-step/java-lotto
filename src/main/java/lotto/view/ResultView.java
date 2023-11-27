package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.LottosResult;

public interface ResultView {
    void showLottos(Lottos lottos);

    void winningStats(LottosResult lottosResult);
}
