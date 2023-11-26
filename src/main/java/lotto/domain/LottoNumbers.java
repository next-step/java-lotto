package lotto.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoNumbers {

        private static final int COUNT_OF_LOTTO_NUMBERS_LIMIT = 6;

        private final Set<LottoNumber> values;

        public LottoNumbers(Set<LottoNumber> values) {
                validateCountOfLottoNumbers(values);
                this.values = values.stream().sorted().collect(Collectors.toCollection(TreeSet::new));
        }

        public LottoNumbers(int... values) {
                this(Arrays.stream(values).mapToObj(LottoNumber::new).sorted()
                    .collect(Collectors.toCollection(TreeSet::new)));
        }

        public Set<LottoNumber> values() {
                return values;
        }

        public boolean hasMatchingNumber(LottoNumber number) {
                return values.contains(number);
        }

        private void validateCountOfLottoNumbers(Set<LottoNumber> values) {
                if (isNotCountOfLottoNumbersLimit(values.size())) {
                        throw new IllegalArgumentException("로또는 6개의 중복되지 않는 번호를 가져야 합니다.");
                }
        }

        private boolean isNotCountOfLottoNumbersLimit(int count) {
                return count != COUNT_OF_LOTTO_NUMBERS_LIMIT;
        }
}
