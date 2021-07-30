package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    @DisplayName("생성자가 1 ~ 45 범위 외의 숫자를 전달 받으면 IllegalArgumentException throw 한다.")
    void constructor_number_out_of_range() {
        assertThatThrownBy(() -> LottoNumber.valueOf(0)).isInstanceOf(
                IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoNumber.valueOf(46)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    @DisplayName("생성자가 1 ~ 45 숫자를 받늗다.")
    void constructor_in_range() {
        assertThat(LottoNumber.valueOf(1)).isEqualTo(LottoNumber.valueOf(1));
        assertThat(LottoNumber.valueOf(45)).isEqualTo(LottoNumber.valueOf(45));
    }

    @Test
    @DisplayName("두 수를 비교했을 때 첫번째 숫자가 두번째 숫자보다 작다.")
    void comparable_less_than() {
        LottoNumber one = LottoNumber.valueOf(1);
        LottoNumber two = LottoNumber.valueOf(2);
        assertThat(one.compareTo(two) < 0).isTrue();
    }

    @Test
    @DisplayName("두 수를 비교해서 크기가 같다.")
    void comparable_equals() {
        LottoNumber number = LottoNumber.valueOf(2);
        LottoNumber sameNumber = LottoNumber.valueOf(2);
        assertThat(number.compareTo(sameNumber) == 0).isTrue();
    }

    @Test
    @DisplayName("두 수를 비교했을 때 첫번째 숫자가 두번째 숫자보다 크다.")
    void comparable_greater_than() {
        LottoNumber one = LottoNumber.valueOf(1);
        LottoNumber two = LottoNumber.valueOf(2);
        assertThat(two.compareTo(one) > 0).isTrue();
    }
}
