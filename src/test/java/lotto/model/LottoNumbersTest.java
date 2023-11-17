package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static lotto.model.LottoNumbers.validateNumberRange;
import static lotto.model.LottoNumbers.validateSizeAndDistinct;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @Test
    @DisplayName("로또 번호가 중복이면 에러")
    void test1() throws Exception {
        Set<Integer> numbers = new HashSet<>(Set.of(1, 2, 3, 4, 5));
        numbers.add(1);
        assertThatThrownBy(() -> validateSizeAndDistinct(numbers))
                .hasMessageContaining("중복");
    }

    @Test
    @DisplayName("로또 번호가 6개가 아니면 에러")
    void test2() throws Exception {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> validateSizeAndDistinct(numbers))
                .hasMessageContaining("6개가 아닙니다");
    }

    @Test
    @DisplayName("로또 번호는 1이상 45이하이다.")
    void test3() throws Exception {
        int outRangeNumber = 57;
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, outRangeNumber);
        assertThatThrownBy(() -> validateNumberRange(numbers))
                .hasMessageContaining("1~45 사이");
    }
}