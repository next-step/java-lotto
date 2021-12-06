package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ranks {

    public List<Rank> getRankList(Lottos lottos, WinningLotto winningLotto) {
        return lottos.getLottos().stream().map(num -> getRank(num.lottoNumList, winningLotto))
                .collect(Collectors.toList());
    }

    private Rank getRank(List<Integer> lottoNumList, WinningLotto winningLotto) {
        int count = Math.toIntExact(lottoNumList.stream().filter(winningLotto.lottoNumList::contains).count());
        boolean bonus = lottoNumList.contains(winningLotto.getBonusNum());

        return Rank.valueOf(count, bonus);
    }

}
