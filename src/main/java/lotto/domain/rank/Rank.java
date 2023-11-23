package lotto.domain.rank;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public interface Rank {

    int score = 0;

    int getScore();

    int getRank();

    void apply(WinningLotto winningLotto, Lotto lotto);
}
