package lotto;

import java.util.List;

public interface LottoPrizeStrategy {
    long getMatch(Lotto lotto, List<Lotto> targetLottoList);
}
