package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("[6개 미만의 숫자] 로또는 6개의 숫자로 이루어진다")
    @Test
    void 숫자_6개_보다_적은_경우() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Lotto.from(numbers));
    }

    @DisplayName("[6개 초과의 숫자] 로또는 6개의 숫자로 이루어진다")
    @Test
    void 숫자_6개_보다_많은_경우() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Lotto.from(numbers));
    }

    @DisplayName("[중복되는 숫자] 로또는 서로 다른 6개의 숫자로 이루어진다")
    @Test
    void 중복되는_숫자가_있는_경우() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Lotto.from(numbers));
    }

    @DisplayName("생성된 로또의 숫자를 확인할 수 있다")
    @Test
    void 로또_번호_확인() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.from(numbers);

        List<Integer> actual = lotto.getLottoNumbers().stream()
                .map(LottoNumber::get)
                .collect(Collectors.toList());

        assertThat(actual).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}
