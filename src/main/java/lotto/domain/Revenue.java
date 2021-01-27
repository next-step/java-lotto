package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum Revenue {
    THREE_MATCHES(5000, 3, false),
    FOUR_MATCHES(50000, 4, false),
    FIVE_MATCHES(1500000, 5, false),
    FIVE_AND_BONUS_MATCHES(30000000, 5, true),
    SIX_MATCHES(2000000000, 6, false),
    NOTHING(0, 0, false);

    private long revenue;
    private int matchNum;
    private boolean bonus;

    Revenue(long revenue, int matchNum, boolean bonus) {
        this.revenue = revenue;
        this.matchNum = matchNum;
        this.bonus = bonus;
    }

    public static Revenue checkTheNumberOfMatchingLotto(List<Integer> lottoNumbers,
        List<Integer> winningNumbers, int bonusNumber) {
        long matchingCount = winningNumbers.stream()
            .filter(winningNumber -> lottoNumbers.contains(winningNumber)).count();

        return Arrays.stream(Revenue.values())
            .filter(revenue -> revenue.matchNum == matchingCount
                && revenue.bonus == lottoNumbers
                .contains(bonusNumber))
            .findFirst()
            .get();
    }
}
