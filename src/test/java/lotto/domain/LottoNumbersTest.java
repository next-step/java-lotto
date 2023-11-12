package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @DisplayName("로또번호가 있으면 true를 반환한다.")
    @Test
    void isRightTest() {
        final Set<Integer> numbers = new HashSet<>();
        numbers.add(3);
        final LottoNumbers lottoNumbers = new LottoNumbers(numbers);

        final boolean result = lottoNumbers.isRight(3);

        assertThat(result).isTrue();
    }
}