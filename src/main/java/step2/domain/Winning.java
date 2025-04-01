package step2.domain;

import java.util.Set;

public class Winning {
    private final Set<LottoNum> nums;
    private final LottoNum bonus;

    public Winning(Set<LottoNum> nums, LottoNum bonus) {
        validate(nums);
        this.nums = nums;
        this.bonus = bonus;
    }

    private void validate(Set<LottoNum> nums) {
        if (nums.size() != 6) {
            throw new IllegalArgumentException("당첨번호는 중복없이 6개를 입력해야 합니다.");
        }
    }

    public int size() {
        return nums.size();
    }

    public MatchResult match(Lotto lotto) {
        return new MatchResult(lotto.countMatch(this.nums), lotto.matchBonus(this.bonus));
    }
}
