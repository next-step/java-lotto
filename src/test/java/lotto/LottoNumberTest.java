package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    @DisplayName("로또 번호는 번호가 1 ~ 45의 범위를 가질 때 정상적으로 생성된다.")
    void create() {
        Assertions.assertThatNoException().isThrownBy(() -> new LottoNumber(1));
        Assertions.assertThatNoException().isThrownBy(() -> new LottoNumber(45));
    }
}
