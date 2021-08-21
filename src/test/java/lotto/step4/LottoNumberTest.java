package lotto.step4;

import lotto.step4.domain.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {

    @Test
    @DisplayName("원시값을 포장한 lottoNumber 를 생성한다. ")
    void create() {
        LottoNumber lottoNumber = LottoNumber.of(1);
        assertThat(LottoNumber.of("1")).isEqualTo(lottoNumber);
    }

    @Test
    @DisplayName("정적 팩토리 메서드를 사용하여 인스턴스를 재사용 한다. ")
    void create2() {
        LottoNumber lottoNumber = LottoNumber.of(1);
        assertThat(LottoNumber.of("1") == lottoNumber).isTrue();
    }

    @ParameterizedTest
    @DisplayName("로또 번호는 1~45 사이 숫자만 올 수 있다.")
    @ValueSource(ints = {-1, 0, 46})
    void checkValidLottoNumber(int number) {
        assertThatThrownBy(() -> LottoNumber.of(number)).isInstanceOf(IllegalArgumentException.class);
    }
}
