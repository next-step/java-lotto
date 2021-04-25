package step4.lotto.domain;

import java.util.List;

public interface Matchable {
    Rank match(Lotto userLotto);
}
