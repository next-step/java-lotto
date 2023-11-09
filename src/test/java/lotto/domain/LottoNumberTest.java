package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoNumberTest {

    @Test
    void 입력된_숫자가_리스트에_있는지_알_수_있다() {
        LottoNumber lottoNumber = new LottoNumber(List.of(1, 2, 3, 4, 5, 6));

        assertAll(
                () -> {
                    boolean actual = lottoNumber.contains(1);

                    assertThat(actual).isTrue();
                },
                () -> {
                    boolean actual = lottoNumber.contains(7);

                    assertThat(actual).isFalse();
                }
        );
    }

}
