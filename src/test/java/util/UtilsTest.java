package util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.LottoNumber;

class UtilsTest {

    @Test
    void 문자열_배열을_숫자_리스트로_변환한다() {
        // given
        final String[] stringNumbers = {"1", "2", "3", "4", "5", "6"};

        // when
        final List<Integer> numbers = Utils.convertToNumbers(stringNumbers);

        // then
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 숫자_리스트를_LottoNumber리스트로_변환한다() {
        // given
        final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // when
        final List<LottoNumber> lottoNumbers = Utils.convertToLottoNumbers(numbers);

        // then
        assertThat(lottoNumbers).hasSize(6)
                .contains(new LottoNumber(1), new LottoNumber(2));
    }
}
