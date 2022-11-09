package lotto;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 10, 20, 30, 40, 44, 45})
    void 로또숫자는_1부터_45까지(int number) {
        assertThat(new LottoNumber(number)).isEqualTo(new LottoNumber(String.valueOf(number)));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 47})
    void 로또숫자_범위를_벗어나면_에러(int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "test", "테스트", "%"})
    void 숫자가_아닌값이면_에러(String str) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber(str));
    }

    @Test
    void 전체_목록_반환은_1부터_45까지() {
        List<LottoNumber> expected = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            expected.add(new LottoNumber(i));
        }

        assertThat(LottoNumber.all()).isEqualTo(expected);
    }
}
