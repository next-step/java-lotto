package study.lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {
    @Test
    @DisplayName("로또 번호가 6개가 아닐 경우, IllegalArgumentException 예외 발생")
    void invalid_lotto_number_size_the_throw_IllegalArgumentException() {
        // given
        Integer[] invalidLottoNumbers = {1, 2, 3, 4, 5, 6, 7};

        // when, then
        assertThatThrownBy(() -> new LottoNumbers(invalidLottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호 선택 갯수는 6개입니다: " + invalidLottoNumbers.length);
    }

    @Test
    @DisplayName("정렬된 로또 번호 Set 반환")
    void numbers() {
        // given
        LottoNumbers lottoNumbers = new LottoNumbers(1, 6, 2, 5, 3, 4);

        // when, then
        assertThat(lottoNumbers.numbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }
}