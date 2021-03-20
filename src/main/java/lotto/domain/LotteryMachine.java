package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryMachine {
    private final WinningLotto winningLotto;
    private final Amount purchaseAmount;

    private LinkedHashMap<Integer, Integer> resultMap = new LinkedHashMap<>();

    public LotteryMachine(final String winningNumbers, final Amount purchaseAmount) {
        this(new WinningLotto(winningNumbers), purchaseAmount);
    }

    public LotteryMachine(final WinningLotto winningLotto, final Amount purchaseAmount) {
        initialize();
        this.winningLotto = winningLotto;
        this.purchaseAmount = purchaseAmount;
    }

    public void initialize() {
        resultMap.put(WinningTable.THREE.matchNumber, 0);
        resultMap.put(WinningTable.FOUR.matchNumber, 0);
        resultMap.put(WinningTable.FIVE.matchNumber, 0);
        resultMap.put(WinningTable.SIX.matchNumber, 0);
    }

    public LottoResult result(List<Lotto> lottos) {
        raffle(lottos)
                .forEach(matchNumber -> {
                    if (resultMap.get(matchNumber) != null) {
                        resultMap.put(matchNumber, resultMap.get(matchNumber) + 1);
                    }
                });
        return new LottoResult(resultMap, purchaseAmount);
    }

    public List<Integer> raffle(List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> correctCount(lotto, winningLotto))
                .collect(Collectors.toList());
    }

    public int correctCount(Lotto lotto, WinningLotto winningLotto) {
        return (int) lotto.numbers()
                .stream()
                .filter(winningLotto::contains).count();
    }
}

