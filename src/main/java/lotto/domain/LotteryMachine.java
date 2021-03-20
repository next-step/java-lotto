package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryMachine {
    private WinningNumbers winningNumbers;
    private LinkedHashMap<Integer, Integer> resultMap = new LinkedHashMap<>();

    public LotteryMachine(String winningNumbers) {
        this(new WinningNumbers(winningNumbers));
    }

    public LotteryMachine(WinningNumbers winningNumbers) {
        initialize();
        this.winningNumbers = winningNumbers;
    }

    public void initialize() {
        resultMap.put(3, 0);
        resultMap.put(4, 0);
        resultMap.put(5, 0);
        resultMap.put(6, 0);
    }

    public LinkedHashMap<Integer, Integer> result(List<Lotto> lottos) {
        raffleResults(lottos)
                .forEach(matchNumber -> {
                    if (resultMap.get(matchNumber) != null) {
                        resultMap.put(matchNumber, resultMap.get(matchNumber) + 1);
                    }
                });
        return resultMap;
    }

    public List<Integer> raffleResults(List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> correctCount(lotto, winningNumbers))
                .collect(Collectors.toList());
    }

    public int correctCount(Lotto lotto, WinningNumbers winningNumbers) {
        return (int) lotto.numbers()
                .stream()
                .filter(winningNumbers::contains).count();
    }
}

