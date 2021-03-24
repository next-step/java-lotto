package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryMachine {
    private final WinningLotto winningLotto;
    private final Amount purchaseAmount;

    private LinkedHashMap<String, Integer> resultMap = new LinkedHashMap<>();

    public LotteryMachine(final WinningLotto winningLotto, final Amount purchaseAmount) {
        initialize();
        this.winningLotto = winningLotto;
        this.purchaseAmount = purchaseAmount;
    }

    public void initialize() {
        resultMap.put(WinningTable.FIFTH.name(), 0);
        resultMap.put(WinningTable.FOURTH.name(), 0);
        resultMap.put(WinningTable.THIRD.name(), 0);
        resultMap.put(WinningTable.SECOND.name(), 0);
        resultMap.put(WinningTable.FIRST.name(), 0);
    }

    public LottoResult result(List<Lotto> lottos) {
        raffle(lottos).forEach(this::plusCorrectCount);
        return new LottoResult(resultMap, purchaseAmount);
    }

    public List<String> raffle(List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> WinningTable.of(correctCount(lotto),
                        checkSecond(lotto)).name())
                .collect(Collectors.toList());
    }

    public int correctCount(Lotto lotto) {
        return (int) lotto.numbers()
                .stream()
                .filter(winningLotto::contains).count();
    }

    public void plusCorrectCount(String winningResult) {
        if (resultMap.get(winningResult) != null) {
            resultMap.put(winningResult, resultMap.get(winningResult) + 1);
        }
    }

    public boolean checkSecond(Lotto lotto) {
        return lotto.numbers().contains(winningLotto.bonusNumber());
    }
}

