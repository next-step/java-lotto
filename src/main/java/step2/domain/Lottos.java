package step2.domain;

import step2.dto.WinLotteryResult;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Lottos {
    public static Lottos EMPTY = Lottos.of(Collections.emptyList());
    private final List<Lotto> lottoList;

    private Lottos(final List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static Lottos of(final List<Lotto> lottos) {
        if (lottos == null) {
            return new Lottos(Collections.emptyList());
        }
        return new Lottos(lottos);
    }

    public int size() {
        return lottoList.size();
    }

    public WinLotteryResult countHitNumber(final Lotto winningLottery) {
        final WinLotteryCalculator calculator = new WinLotteryCalculator();
        for (final Lotto lotto : lottoList) {
            final int hitCount = lotto.countHitNumber(winningLottery);
            final Optional<Reward> rewardOptional = Reward.find(hitCount);
            rewardOptional.ifPresent(calculator::increaseHitCount);
        }
        return calculator.toWinLotteryResult();
    }

    public List<List<Integer>> getAllLottoNumber() {
        return lottoList.stream().map(Lotto::getLottoNumber).collect(Collectors.toList());
    }
}
