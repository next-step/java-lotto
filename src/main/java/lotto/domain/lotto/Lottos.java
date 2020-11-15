package lotto.domain.lotto;

import lotto.domain.rank.RankHitCountStore;
import lotto.dto.WinLotteryResult;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    public static Lottos EMPTY = Lottos.of(Collections.emptyList());
    private final List<Lotto> lottoList;

    private Lottos(final List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static Lottos of(final List<Lotto> lottos) {
        if (lottos == null) {
            return EMPTY;
        }
        return new Lottos(lottos);
    }

    public int size() {
        return lottoList.size();
    }

    public WinLotteryResult getWinLotteryResult(final Lotto winningLottery) {
        final RankHitCountStore rankHitCountStore = new RankHitCountStore();
        for (final Lotto lotto : lottoList) {
            final int hitCount = lotto.countHitNumber(winningLottery);
            rankHitCountStore.increaseHitCount(hitCount);
        }
        return rankHitCountStore.toWinLotteryResult();
    }

    public List<List<Integer>> getAllLottoNumber() {
        return lottoList.stream().map(Lotto::getLottoNumber).collect(Collectors.toList());
    }
}
