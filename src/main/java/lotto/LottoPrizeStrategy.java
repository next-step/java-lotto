package lotto;

import java.util.List;

public interface LottoPrizeStrategy {
    int getMatch(Lotto lotto, List<Lotto> targetLottoList);
}
