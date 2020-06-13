package lotto.domain.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class LottoNumberTest {
    @Test
    void 생성_테스트() {
        assertThatCode(() -> LottoNumber.create(5)).doesNotThrowAnyException();
    }
}
