package lotto.domain;

import lotto.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @Test
    @DisplayName("로또 번호 리스트 확인")
    void getLottoNumbers() {
        // given
        List<Integer> inputNumbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        LottoNumbers lottoNumbers = new LottoNumbers(inputNumbers);

        // then
        assertThat(lottoNumbers.getLottoNumbers()).isEqualTo(inputNumbers);
    }

    @Test
    @DisplayName("로또 번호가 6개 보다 적으면 예외 처리")
    void getLottoNumbers_fail_1() {
        // given
        List<Integer> inputNumbers = List.of(1, 2, 3, 4, 5);

        // exception
        assertThatThrownBy(() -> new LottoNumbers(inputNumbers))
                .isInstanceOf(InvalidInputException.class);
    }

    @Test
    @DisplayName("로또 번호가 6개 보다 많으면 예외 처리")
    void getLottoNumbers_fail_2() {
        // given
        List<Integer> inputNumbers = List.of(1, 2, 3, 4, 5, 6, 7);

        // exception
        assertThatThrownBy(() -> new LottoNumbers(inputNumbers))
                .isInstanceOf(InvalidInputException.class);
    }
}
