package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.LottoNumberOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @Test
    @DisplayName("펙토리 메서드는 캐싱되어 있는 인스턴스를 반환한다.")
    void givenOfNumber_whenOfSameNumber_thenSameInstance() {
        assertThat(LottoNumber.of(1) == LottoNumber.of(1)).isTrue();
        assertThat(LottoNumber.of(45) == LottoNumber.of(45)).isTrue();
    }

    @Test
    @DisplayName("생성자가 1 ~ 45 범위 외의 숫자를 전달 받으면 LottoNumberOutOfRangeException throw 한다.")
    void constructor_number_out_of_range() {
        assertThatThrownBy(() -> LottoNumber.of(0)).isInstanceOf(
               LottoNumberOutOfRangeException.class);
        assertThatThrownBy(() -> LottoNumber.of(46)).isInstanceOf(
                LottoNumberOutOfRangeException.class);
    }

    @Test
    @DisplayName("두 수를 비교했을 때 첫번째 숫자가 두번째 숫자보다 작다.")
    void comparable_less_than() {
        LottoNumber one = LottoNumber.of(1);
        LottoNumber two = LottoNumber.of(2);
        assertThat(one.compareTo(two) < 0).isTrue();
    }

    @Test
    @DisplayName("두 수를 비교해서 크기가 같다.")
    void comparable_equals() {
        LottoNumber number = LottoNumber.of(2);
        LottoNumber sameNumber = LottoNumber.of(2);
        assertThat(number.compareTo(sameNumber) == 0).isTrue();
    }

    @Test
    @DisplayName("두 수를 비교했을 때 첫번째 숫자가 두번째 숫자보다 크다.")
    void comparable_greater_than() {
        LottoNumber one = LottoNumber.of(1);
        LottoNumber two = LottoNumber.of(2);
        assertThat(two.compareTo(one) > 0).isTrue();
    }
}
