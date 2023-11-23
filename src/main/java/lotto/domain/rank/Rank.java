package lotto.domain.rank;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public interface Rank {

    int score = 0;

    int score();

    int rank();

    void apply(WinningLotto winningLotto, Lotto lotto);
}
