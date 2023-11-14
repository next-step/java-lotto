package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {

    @Test
    void 입력된_숫자가_리스트에_있는지_알_수_있다() {
        Lotto lotto = new Lotto(List.of(LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)));

        assertAll(
                () -> {
                    boolean actual = lotto.contains(LottoNumber.of(1));

                    assertThat(actual).isTrue();
                },
                () -> {
                    boolean actual = lotto.contains(LottoNumber.of(7));

                    assertThat(actual).isFalse();
                }
        );
    }

    @Test
    void 입력된_숫자가_중복이_있으면_예외가_발생한다() {
        List<LottoNumber> actual = List.of(LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(2),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6));
        assertThrows(IllegalArgumentException.class, () -> new Lotto(actual));
    }

}
