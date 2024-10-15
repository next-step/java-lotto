package lotto.entity;

import java.util.List;
import java.util.Set;

public class LottoNumberSize {
    private static final int MIN_ISSUE_NUMBER = 0;
    private static final int MAX_LOTTO_NUMBER_SIZE = 6;

    public static List<Integer> sliceLottoNumbers(List<Integer> numbers) {
        return numbers.subList(MIN_ISSUE_NUMBER, MAX_LOTTO_NUMBER_SIZE);
    }

    public static void validateSize(Set<Integer> result) {
        if (result.size() != MAX_LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("사이즈가 여섯개 아님");
        }
    }
}
