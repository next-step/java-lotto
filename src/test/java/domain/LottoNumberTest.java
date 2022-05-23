package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    void create() {
        //given
        int number = 1;

        //when
        LottoNumber result = new LottoNumber(number);

        //then
        assertThat(result).isEqualTo(new LottoNumber(number));
    }

    @Test
    void numberMinMax() {
        //given
        int overMaxNumber = 46;
        int underMinNumber = -1;

        //then
        assertThatThrownBy(() -> new LottoNumber(overMaxNumber))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoNumber(underMinNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
