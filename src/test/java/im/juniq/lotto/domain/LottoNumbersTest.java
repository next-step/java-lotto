package im.juniq.lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @Test
    void create() {
        assertThatCode(() -> new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("두 개의 Numbers 객체를 비교하여, 서로 일치하는 숫자 개수를 조회")
    void matchedCount() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(new LottoNumbers(numbers).matchedCount(new LottoNumbers(numbers))).isEqualTo(6);
        assertThat(new LottoNumbers(numbers).matchedCount(new LottoNumbers(Arrays.asList(1,2,3,4,5,7)))).isEqualTo(5);
        assertThat(new LottoNumbers(numbers).matchedCount(new LottoNumbers(Arrays.asList(7,8,9,10,11,12)))).isEqualTo(0);
    }
}
