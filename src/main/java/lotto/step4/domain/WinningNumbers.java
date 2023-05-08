package lotto.step4.domain;

import lotto.step4.enums.Rank;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers extends ValidateNumbers {
    private final Set<Integer> winningNumbers;
    private final int bonusNumber;

    public Set<Integer> getWinningNumbers() {
        return Set.copyOf(winningNumbers);
    }

    public WinningNumbers(Set<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = validateNumbers(winningNumbers);
        this.bonusNumber = validateBonusNumber(bonusNumber, winningNumbers);
    }


    public Result getWinnerStat(Lottos lottos) {
        Map<Integer, Long> rankMap = lottos.getLottos().stream()
                .map(this::matchLotto)
                .map(this::matchRank)
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        Map<Rank, Long> stat = rankMap.entrySet().stream()
                .collect(Collectors.toMap(
                        e -> Rank.of(e.getKey()).get(),
                        Map.Entry::getValue
                ));

        return new Result(stat);
    }

    private Map<Integer, Boolean> matchLotto(Lotto lotto) {
        Map<Integer, Boolean> map = new HashMap<>();
        int matchCount = (int) lotto.getLotto().stream().filter(winningNumbers::contains).count();
        boolean matchBonus = lotto.getLotto().contains(bonusNumber);
        map.put(matchCount, matchBonus);
        return map;
    }

    private int matchRank(Map<Integer, Boolean> matchMap) {
        for (Map.Entry<Integer, Boolean> entry : matchMap.entrySet()) {
            int matchCount = entry.getKey();
            boolean matchBonus = entry.getValue();
            if (matchCount == 6) {
                return 1;
            }
            if (matchCount == 5 && matchBonus) {
                return 2;
            }
            if (matchCount > 2) {
                return 6 - matchCount + 2;
            }
        }
        return 0;
    }
}
