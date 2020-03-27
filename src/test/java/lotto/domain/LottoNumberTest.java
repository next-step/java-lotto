package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {
    @DisplayName("1 ~ 45 범위의 숫자를 가진 로또 숫자 객체를 생성할 수 있다.")
    @Test
    void create() {
        final LottoNumber expect = new LottoNumber(1);

        final LottoNumber actual = new LottoNumber(1);

        assertThat(actual).isNotNull();
        assertThat(actual).isEqualTo(expect);
    }
}