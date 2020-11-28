package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(Lotto... lottos) {
        this(Arrays.asList(lottos));
    }

    public Lottos(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public int getPaidMoney() {
        return lottos.size() * Lotto.PRICE;
    }

    public List<RankedLotto> checkRanking(WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(it -> {
                    long matchedCount = winningNumbers.getMatchedWinningNumberCount(it);
                    boolean matchedBonus = winningNumbers.matchBonusNumber(it);

                    return new RankedLotto(LottoRanking.valueOf(matchedCount, matchedBonus), it);
                })
                .collect(Collectors.toList());
    }
}
