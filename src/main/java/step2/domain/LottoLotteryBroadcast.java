package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoLotteryBroadcast {

    public static List<Integer> broadcast(List<Lotto> lottos, WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(lotto -> lotto.findWinningNumbersCount(winningNumbers))
                .collect(Collectors.toList());
    }

}
