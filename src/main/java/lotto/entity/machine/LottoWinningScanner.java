package lotto.entity.machine;

import lotto.entity.Lotto;
import lotto.entity.PrizeMoney;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoWinningScanner {


    private LottoWinningScanner() {

    }

    public static List<PrizeMoney> winnerResult(List<Lotto> lottos, List<Integer> winnersNumber) {
        List<PrizeMoney> result = new ArrayList<>();

        for (Lotto lotto : lottos) {
            PrizeMoney prizeMoney = PrizeMoney.findByCount(lotto.matchCount(winnersNumber));
            result.add(prizeMoney);
        }

        return result.stream().filter(l -> l != PrizeMoney.LOSE).collect(Collectors.toList());
    }
}
