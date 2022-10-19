package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {

    private LottoResult() {
        throw new AssertionError();
    }


    public static List<Rank> rankResult(Lottos lottos) {
        return lottos.getLottoList()
                .stream()
                .map(Lotto::getRank)
                .collect(Collectors.toList());
    }

    public static Integer yieldResult(Lottos lottos) {
        int totalWinningMoney = lottos.getLottoList()
                .stream()
                .mapToInt(l -> l.getRank().getWinningMoney())
                .sum();
        return totalWinningMoney / lottos.getPurchasePrice();
    }

}
