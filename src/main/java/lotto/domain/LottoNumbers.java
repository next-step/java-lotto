package lotto.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoNumbers {

        private static final int COUNT_OF_LOTTO_NUMBERS_LIMIT = 6;

        private final Set<LottoNumber> values;

        public LottoNumbers(Set<LottoNumber> values) {
                this.values = values.stream().sorted().collect(Collectors.toCollection(TreeSet::new));
                validateCountOfLottoNumbers();
        }

        public LottoNumbers(int... values) {
                this(Arrays.stream(values).mapToObj(LottoNumber::new).sorted()
                    .collect(Collectors.toCollection(TreeSet::new)));
        }

        public Set<LottoNumber> values() {
                return values;
        }

        private void validateCountOfLottoNumbers() {
                if (this.values.size() != COUNT_OF_LOTTO_NUMBERS_LIMIT) {
                        throw new IllegalArgumentException("로또는 6개의 번호를 가져야 합니다.");
                }
        }

        public boolean hasWinningNumber(LottoNumber winningNumber) {
                return values.contains(winningNumber);
        }

        public boolean hasBonusNumber(LottoNumber bonusNumber) {
                return values.contains(bonusNumber);
        }
}
