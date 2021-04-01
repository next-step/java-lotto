package step2.domain.check;

import step2.domain.lotto.Lotto;
import step2.domain.winning.WinningResult;
import step2.domain.winning.WinningScore;
import step2.exception.LottoNullPointerException;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class LottoWinningCheckMachine {

    private final static int ZERO = 0;
    private final static int INCREASE = 1;

    private final Lotto winningLotto;

    private LottoWinningCheckMachine(Lotto winningLotto) {
        validate(winningLotto);
        this.winningLotto = winningLotto;
    }

    public static final LottoWinningCheckMachine of(Lotto winningLotto) {
        return new LottoWinningCheckMachine(winningLotto);
    }

    private final void validate(Lotto winningLotto) {
        if (Objects.isNull(winningLotto)) {
            throw new LottoNullPointerException();
        }
    }

    public final WinningResult generateWinningResult(Set<Lotto> lottos) {
        Map<WinningScore, Integer> winningMap = generateAndInitWinningMap();
        lottos.stream()
                .map(lotto -> lotto.getCorrectCount(winningLotto))
                .map(WinningScore::valueOf)
                .forEach(winningScore -> winningMap.put(winningScore, winningMap.get(winningScore) + INCREASE));
        return WinningResult.of(winningMap);
    }

    private final Map<WinningScore, Integer> generateAndInitWinningMap() {
        Map<WinningScore, Integer> winningMap = new EnumMap<>(WinningScore.class);
        for (WinningScore winningScore : WinningScore.values()) {
            winningMap.put(winningScore, ZERO);
        }
        return winningMap;
    }
}
