package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {

    @Test
    void 입력된_숫자가_리스트에_있는지_알_수_있다() {
        Lotto lotto = new Lotto(List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)));

        assertAll(
                () -> {
                    boolean actual = lotto.contains(new LottoNumber(1));

                    assertThat(actual).isTrue();
                },
                () -> {
                    boolean actual = lotto.contains(new LottoNumber(7));

                    assertThat(actual).isFalse();
                }
        );
    }

    @Test
    void 입력된_숫자가_중복이_있으면_예외가_발생한다() {
        List<LottoNumber> actual = List.of(new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(2),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));
        assertThrows(IllegalArgumentException.class, () -> new Lotto(actual));
    }

}
