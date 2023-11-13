package lotto.step2.domain;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {
    private final Set<LottoNumber> nums;

    public Lotto(final Set<Integer> nums) {
        validateSize(nums);

        final TreeSet<LottoNumber> lottoNumbers = nums.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(TreeSet::new));

        this.nums = Collections.unmodifiableSet(lottoNumbers);
    }

    public Set<LottoNumber> nums() {
        return this.nums;
    }

    @Override
    public String toString() {
        return this.nums.toString();
    }

    private void validateSize(final Set<Integer> nums) {
        if (nums.size() != 6) {
            throw new IllegalArgumentException("lotto nums size must be 6");
        }
    }

    public LottoRank calculateLottoRank(final WinnerNumbers winnerNumbers) {
        return LottoRank.findByCountAndBonusMatching(
                calculateLottoNumsMatchingCount(winnerNumbers.nums()),
                this.nums.contains(winnerNumbers.getBonusNumber()));
    }

    private int calculateLottoNumsMatchingCount(final Set<LottoNumber> winnerNums) {
        return (int) this.nums.stream()
                .filter(winnerNums::contains)
                .count();
    }

    public boolean contains(final LottoNumber bonusLottoNumber) {
        return this.nums.contains(bonusLottoNumber);
    }
}
