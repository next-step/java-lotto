package lotto.domain;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {

        private final Set<LottoNumber> values;

        public LottoNumbers(Set<Integer> values) {
                this.values = values.stream().map(LottoNumber::new)
                    .sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        }

        public LottoNumbers(int... values) {
                this.values = Arrays.stream(values).mapToObj(LottoNumber::new)
                    .collect(Collectors.toSet());
        }

        public int[] values() {
                return values.stream().mapToInt(LottoNumber::value).toArray();
        }
}
