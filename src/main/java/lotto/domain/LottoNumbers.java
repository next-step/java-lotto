package lotto.domain;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoNumbers {

        private final Set<LottoNumber> values;

        public LottoNumbers(Set<Integer> values) {
                this.values = values.stream().map(LottoNumber::new)
                    .sorted().collect(Collectors.toCollection(TreeSet::new));
        }

        public LottoNumbers(int... values) {
                this(Arrays.stream(values).boxed().sorted().collect(Collectors.toCollection(TreeSet::new)));
        }

        public Set<LottoNumber> values() {
                return values;
        }

        public boolean isWinningNumberContained(int winningNumber) {
                return values.stream().mapToInt(LottoNumber::value).anyMatch(value -> value == winningNumber);
        }

        public boolean isBonusNumberContained(LottoNumber bonusNumber) {
                return values.stream().anyMatch(value -> value == bonusNumber);
        }
}
