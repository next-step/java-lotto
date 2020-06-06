package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMatcher {
    private final List<LottoPrize> lottoPrizeList;

    public LottoMatcher(List<Lotto> lottos, List<Integer> winningNumbers) {
        this.lottoPrizeList = new ArrayList<>();
        matchList(lottos, winningNumbers);
    }

    private void matchList(List<Lotto> lottos, List<Integer> winningNumbers) {
        for (Lotto lotto : lottos) {
            int countOfMatch = lotto.matches(winningNumbers);
            lottoPrizeList.add(LottoPrize.valueOf(countOfMatch));
        }
    }

    public List<LottoPrize> getLottoPrizeList() {
        return lottoPrizeList;
    }
}
