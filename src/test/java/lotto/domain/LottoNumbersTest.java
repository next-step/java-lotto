package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @DisplayName("LottoNumbers의 사이즈는 6이어야 한다. ")
    @Test
    void lotto_number_generate_test() {
        List<LottoNumber> numbers = IntStream.rangeClosed(1, 7)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

        assertThatThrownBy(() -> new LottoNumbers(numbers)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("LottoNumbers는 중복된 값을 가져서는 안된다.")
    @Test
    void check_first_rank() {
        List<LottoNumber> numbers = IntStream.rangeClosed(1, 5)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());
        numbers.add(new LottoNumber(5));

        assertThatThrownBy(() -> new LottoNumbers(numbers)).isInstanceOf(
            IllegalArgumentException.class);
    }
}
