package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @Test
    @DisplayName("로또 번호의 범위가 정상적이면 LottoNumbers 가 정상적으로 생성됩니다.")
    void test01() {
        assertThatNoException().isThrownBy(() -> new LottoNumbers(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("로또 번호의 범위가 정상적이면 에러가 발생합니다.")
    void test02() {
        Assertions.assertAll(
                () -> assertThatThrownBy(() -> new LottoNumbers(-1, 2, 3, 4, 5, 6))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new LottoNumbers(1, 2, 3, 4, 5, 46))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    
}