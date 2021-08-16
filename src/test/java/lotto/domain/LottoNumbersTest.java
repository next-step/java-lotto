package lotto.domain;

import lotto.exception.InputError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @DisplayName("LottoNumber는 숫자가 같으면 같은 객체")
    @Test
    void create() {
        assertThat(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)))
                .isEqualTo(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("LottoNumber 갯수가 6개가 아닐때 InputError 발생")
    @Test
    void createError() {
        assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(InputError.class);
    }

    @DisplayName("다른 로또번호와 비교해 같은 번호 갯수를 찾는다.")
    @Test
    void countSameNumber() {
        LottoNumbers otherLottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 7, 8, 9));
        assertThat(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)).countSameNumber(otherLottoNumbers))
                .isEqualTo(3);
    }

}