package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;

class LottoFactoryTest {

    @DisplayName("랜덤한 번호의 로또를 생성할 때, 오류가 발생하지 않아야 한다.")
    @Test
    void createLotto() {
        assertThatNoException()
                .isThrownBy(() -> LottoFactory.createLotto());
    }

}
