package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("[6개 미만의 숫자] 로또는 6개의 숫자로 이루어진다")
    @Test
    void 숫자_6개_보다_적은_경우() {
        List<LottoNumber> numbers = Arrays.asList(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5)
        );

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Lotto.of(numbers));
    }

    @DisplayName("[6개 초과의 숫자] 로또는 6개의 숫자로 이루어진다")
    @Test
    void 숫자_6개_보다_많은_경우() {
        List<LottoNumber> numbers = Arrays.asList(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6),
            new LottoNumber(7)
        );

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Lotto.of(numbers));
    }

    @DisplayName("[중복되는 숫자] 로또는 서로 다른 6개의 숫자로 이루어진다")
    @Test
    void 중복되는_숫자가_있는_경우() {
        List<LottoNumber> numbers = Arrays.asList(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(6),
            new LottoNumber(6)
        );

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Lotto.of(numbers));
    }

    @DisplayName("생성된 로또의 숫자를 확인할 수 있다")
    @Test
    void 로또_번호_확인() {
        List<LottoNumber> numbers = Arrays.asList(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
        );

        Lotto lotto = Lotto.of(numbers);

        assertThat(lotto.getNumbers()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}
