package lotto.entity;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Numbers {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final Integer LOTTO_NUMBERS_SIZE = 6;

    public static void validateRange(Integer numbers) {
        if (numbers < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < numbers) {
            throw new IllegalArgumentException("1 ~ 45 사이의 값을 입력해 주세요");
        }
    }

    public void validateDuplication(List<Integer> result) {
        Set<Integer> distinct = new HashSet<>(result);
        if (result.size() != distinct.size()) {
            throw new IllegalArgumentException("중복 된 번호");
        }
    }

    public void validateSize(List<Integer> result) {
        if (result.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("사이즈가 여섯개 아님");
        }
    }
}
