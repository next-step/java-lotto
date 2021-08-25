package lotto.domain;

import lotto.exception.InputError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStreamReader;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @DisplayName("LottoNumber는 숫자가 같으면 같은 객체")
    @Test
    void create() {
        assertThat(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)))
                .isEqualTo(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("LottoNumber 갯수가 6개가 아닐때 InputError 발생")
    @Test
    void createError() {
        assertThatThrownBy(() -> Lotto.of(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(InputError.class);
    }

    @DisplayName("다른 로또번호와 비교해 같은 번호 갯수를 찾는다.")
    @Test
    void countSameNumber() {
        Lotto otherLotto = Lotto.of(Arrays.asList(1, 2, 3, 7, 8, 9));
        assertThat(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)).countSameNumber(otherLotto))
                .isEqualTo(3);
    }

    @DisplayName("6개의 번호 중 동일 번호가 있으면 InputError 발생")
    @Test
    void createError_sameNumber() {
        assertThatThrownBy(() -> Lotto.of(Arrays.asList(1, 1, 1, 1, 1, 2)))
                .isInstanceOf(InputError.class);
    }
}