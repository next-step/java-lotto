package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

        private static final int MIN = 1;
        private static final int MAX = 45;

        private final int value;

        public LottoNumber(int value) {
                if (!isValidNumber(value)) {
                        throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이의 번호만 가능합니다.");
                }
                this.value = value;
        }

        public int value() {
                return value;
        }

        private boolean isValidNumber(int value) {
                if (value < MIN) {
                        return false;
                }
                return value <= MAX;
        }

        @Override
        public int compareTo(LottoNumber o) {
                return this.value - o.value;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) {
                        return true;
                }
                if (!(o instanceof LottoNumber)) {
                        return false;
                }
                LottoNumber that = (LottoNumber) o;
                return value == that.value;
        }

        @Override
        public int hashCode() {
                return Objects.hash(value);
        }
}
