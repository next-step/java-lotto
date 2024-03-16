package lotto.model;

import lotto.exception.InvalidLottoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void 초기화시_빈리스트를_넘기면_예외를_던진다() {
        assertThatThrownBy(() -> new Lotto(Collections.emptyList()))
                .isInstanceOf(InvalidLottoException.class);
    }

    @Test
    void 로또번호는_6개만_선택가능하다() {
        assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5))
                .isInstanceOf(InvalidLottoException.class);
        assertThatThrownBy(() -> new Lotto(1, 2, 3, 4, 5, 6, 7))
                .isInstanceOf(InvalidLottoException.class);
    }

    @Test
    void 로또번호를_선택할때_중복번호_없이_6개를_선택해야한다() {
        assertThatThrownBy(() -> new Lotto(1, 1, 1, 4, 5, 6))
                .isInstanceOf(InvalidLottoException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1", "7,0"}, delimiter = ',')
    void 하나의_번호를_로또번호와_매칭한다(int given, int expected) {

        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        int actual = lotto.match(new LottoNumber(given));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 볼하나를_매치할때_null은_넘기면_0을_반환한다() {
        int expected = 0;

        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        int actual = lotto.match(null);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 여러개의_번호를_로또번호와_매칭한다() {
        int expected = 6;

        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        int actual = lotto.matches(LottoNumbers.of(1, 2, 3, 4, 5, 6));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 여러개의_번호를_매치할때_빈리스트를_넘기면_예외를_던진다() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> lotto.matches(Collections.emptyList()))
                .isInstanceOf(InvalidLottoException.class);
    }

    @Test
    void 여러개의_번호를_매치할때_null_넘기면_예외를_던진다() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> lotto.matches(null))
                .isInstanceOf(InvalidLottoException.class);
    }

    @Test
    void 여러개의_번호를_매치할때_일차하는_볼이_없는경우_0을반환한다() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        int actual = lotto.matches(LottoNumbers.of(7, 8, 9, 10, 11, 12));

        assertThat(actual).isEqualTo(0);
    }
}
