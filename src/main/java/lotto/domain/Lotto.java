package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_SIZE = 6;
    private static final int MATCH_COUNT_MIN = 3;
    private static final int MATCH_COUNT_MAX = 6;
    private static final int INIT_COUNT = 1;

    private final Set<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        this(new HashSet<>(numbers));
    }

    public Lotto(Set<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new RuntimeException("로또 번호의 개수는 6개여야 합니다.");
        }
        this.numbers = numbers;
    }

    public void increaseLottoRewardCount(LottoRewards lottoRewards, WinningLotto winningLotto) {
        if (isNotWinningMatchCountWith(winningLotto.numbers())) {
            return;
        }

        int matchCount = matchCount(winningLotto.numbers());
        RewardType rewardType = RewardType.of(matchCount);

        if (rewardType == RewardType.FIVE && isMatchWith(winningLotto.bonusNumber())) {
            rewardType = RewardType.FIVE_AND_BONUS;
        }

        if (lottoRewards.isNotContainRewardType(rewardType)) {
            lottoRewards.add(new LottoReward(rewardType, INIT_COUNT));
            return;
        }
        lottoRewards.increaseCountOf(rewardType);
    }

    private boolean isNotWinningMatchCountWith(Lotto numbers) {
        return matchCount(numbers) < MATCH_COUNT_MIN || matchCount(numbers) > MATCH_COUNT_MAX;
    }

    int matchCount(Lotto numbers) {
        List<LottoNumber> matchNumbers = this.numbers.stream()
                .filter(v -> numbers.value().stream()
                        .anyMatch(Predicate.isEqual(v))).collect(Collectors.toList());
        return matchNumbers.size();
    }

    private boolean isMatchWith(LottoNumber number) {
        return numbers.stream().anyMatch(v -> v.value() == number.value());
    }

    public Set<LottoNumber> value() {
        return this.numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
