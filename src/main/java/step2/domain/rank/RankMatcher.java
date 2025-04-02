package step2.domain.rank;

import step2.domain.lotto.Lotto;
import step2.domain.lotto.WinningLotto;

public interface RankMatcher {
    boolean matches(WinningLotto winningLotto, Lotto lotto);
    String getAdditionalDescription();
}
