package step2.domain;

import java.util.Set;

public class Winning {
    private final Set<LottoNum> nums;

    public Winning(Set<LottoNum> nums) {
        validate(nums);
        this.nums = nums;
    }

    private void validate(Set<LottoNum> nums) {
        if (nums.size() != 6) {
            throw new IllegalArgumentException("당첨번호는 중복없이 6개를 입력해야 합니다.");
        }
    }

    public Set<LottoNum> get() {
        return Set.copyOf(nums);
    }
}
