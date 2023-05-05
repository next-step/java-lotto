package lotto.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {
    @Test
    @DisplayName("LottoNumber 숫자 0 입력 시 return error")
    public void lottoNumber_under_1() {
        int input = 0;

        assertThatThrownBy(() -> new LottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("LottoNumber 숫자 46 입력 시 return error")
    public void lottoNumber_above_45() {
        int input = 46;

        assertThatThrownBy(() -> new LottoNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("LottoNumber 숫자 입력 시 정상 할당")
    public void lottoNumber_return_normal() {
        int input = 30;

        int expected = 30;
        int actual = new LottoNumber(input).number();

        assertThat(actual).isEqualTo(expected);
    }

}