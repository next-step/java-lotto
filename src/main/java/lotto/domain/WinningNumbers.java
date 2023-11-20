package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumbers {

        private static final int WINNING_NUMBERS_COUNT = 6;
        private static final int COUNT_OF_BONUS_NUMBER_ADDED = 7;

        private final Set<LottoNumber> basicWinningNumbers;
        private final LottoNumber bonusNumber;

        public WinningNumbers(List<LottoNumber> values, LottoNumber bonusNumber) {
                validateCountOfWinningNumbersExceptForBonus(values);
                values.add(bonusNumber);
                this.basicWinningNumbers = Set.copyOf(values);
                this.bonusNumber = bonusNumber;
                validateCountOfNumbers();
        }

        public WinningNumbers(LottoNumber bonusNumber, int... values) {
                this(Arrays.stream(values).mapToObj(LottoNumber::new).collect(Collectors.toList()), bonusNumber);
        }

        public Set<LottoNumber> values() {
                return basicWinningNumbers;
        }

        public LottoNumber bonusNumber() {
                return bonusNumber;
        }

        private void validateCountOfWinningNumbersExceptForBonus(List<LottoNumber> lottoNumbers) {
                if (!isFixedCountOfWinningNumbersExceptForBonus(lottoNumbers.size())) {
                        throw new IllegalArgumentException("6개의 당첨번호를 중복되지않게 입력해주세요.");
                }
        }

        private boolean isFixedCountOfWinningNumbersExceptForBonus(int countOfNumber) {
                return countOfNumber == WINNING_NUMBERS_COUNT;
        }

        private void validateCountOfNumbers() {
                if (!isFixedCountOfBonusNumberAdded()) {
                        throw new IllegalArgumentException("6개의 당첨번호와 한개의 보너스번호가 모두 중복되지않게 입력해주세요.");
                }
        }

        private boolean isFixedCountOfBonusNumberAdded() {
                return basicWinningNumbers.size() == COUNT_OF_BONUS_NUMBER_ADDED;
        }
}
