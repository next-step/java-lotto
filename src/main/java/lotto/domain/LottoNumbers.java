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
                this.values = Arrays.stream(values).mapToObj(LottoNumber::new).sorted()
                    .collect(Collectors.toCollection(TreeSet::new));
        }

        public int[] values() {
                return values.stream().mapToInt(LottoNumber::value).toArray();
        }
}
