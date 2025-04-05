package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberTest {

    @Test
    void of_1에서_45사이_숫자면_같은_객체_반환한다() {
        assertThat(LottoNumber.of(2)).isEqualTo(LottoNumber.of(2));
    }

    @Test
    void of_1미만일_경우_예외를_던진다() {
        assertThatThrownBy(() -> LottoNumber.of(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void of_45초과일_경우_예외를_던진다() {
        assertThatThrownBy(() -> LottoNumber.of(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
