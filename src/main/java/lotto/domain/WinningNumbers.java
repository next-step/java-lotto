package lotto.domain;

import java.util.List;

public class WinningNumbers {

        private static final int WINNING_NUMBERS_COUNT = 6;
        private final List<Integer> values;

        public WinningNumbers(List<Integer> values) {
                this.values = values;
                validateCountOfValues();
        }

        public List<Integer> values() {
                return values;
        }

        private void validateCountOfValues() {
                if (!isFixedCount()) {
                        throw new IllegalArgumentException("6개의 당첨번호를 입력해주세요.");
                }
        }

        private boolean isFixedCount() {
                return values.size() == WINNING_NUMBERS_COUNT;
        }
}
