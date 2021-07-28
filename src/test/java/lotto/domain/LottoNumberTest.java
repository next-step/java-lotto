package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    @DisplayName("1 ~ 45 범위 내의 숫자가 아니면 IllegalArgumentException throw 한다.")
    void constructor_number_out_of_range() {
        assertThatThrownBy(() -> LottoNumber.valueOf(0)).isInstanceOf(
                IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoNumber.valueOf(46)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("범위 내의 숫자를 주었을 때 생성자가 실행한다.")
    void constructor_in_range() {
        assertThat(LottoNumber.valueOf(1)).isEqualTo(LottoNumber.valueOf(1));
        assertThat(LottoNumber.valueOf(45)).isEqualTo(LottoNumber.valueOf(45));
    }
}
