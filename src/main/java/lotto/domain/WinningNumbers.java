package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {

        private static final int WINNING_NUMBERS_COUNT = 6;

        private final Set<Integer> values;

        public WinningNumbers(List<Integer> values) {
                this.values = Set.copyOf(values);
                validateCountOfValues();
        }

        public WinningNumbers(int... values) {
                this.values = Arrays.stream(values).boxed().collect(Collectors.toSet());
                validateCountOfValues();
        }

        public Set<Integer> values() {
                return values;
        }

        private void validateCountOfValues() {
                if (!isFixedCount()) {
                        throw new IllegalArgumentException("6개의 당첨번호를 중복되지않게 입력해주세요.");
                }
        }

        private boolean isFixedCount() {
                return values.size() == WINNING_NUMBERS_COUNT;
        }
}
