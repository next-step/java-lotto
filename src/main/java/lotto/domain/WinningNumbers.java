package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumbers {

        private static final int WINNING_NUMBERS_COUNT = 6;
        private static final int COUNT_OF_BONUS_NUMBER_ADDED = 7;
        private Set<Integer> values;
        private LottoNumber bonusNumber;

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

        public LottoNumber bonusNumber() {
                return bonusNumber;
        }

        public void addBonusNumberInToTheWinningNumbers(int bonusNumber) {
                this.bonusNumber = new LottoNumber(bonusNumber);
                addBonusNumber();
                validateBonusNumber();
        }

        private void validateCountOfValues() {
                if (!isFixedCount()) {
                        throw new IllegalArgumentException("6개의 당첨번호를 중복되지않게 입력해주세요.");
                }
        }

        private boolean isFixedCount() {
                return values.size() == WINNING_NUMBERS_COUNT;
        }

        private void validateBonusNumber() {
                if (!isFixedCountOfBonusNumberAdded()) {
                        throw new IllegalArgumentException("기존 입력한 6개의 당첨번호와 중복되지않게 입력해주세요.");
                }
        }

        private boolean isFixedCountOfBonusNumberAdded() {
                return values.size() == COUNT_OF_BONUS_NUMBER_ADDED;
        }

        private void addBonusNumber() {
                values = Stream.concat(values.stream(), Stream.of(bonusNumber.value()))
                    .collect(Collectors.toUnmodifiableSet());
        }
}
