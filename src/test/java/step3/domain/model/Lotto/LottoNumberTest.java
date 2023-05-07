package step3.domain.model.Lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoNumberTest {
    @Test
    void 로또번호_음수테스트() {
        assertThatThrownBy(() -> LottoNumber.from(-1))
                .isInstanceOf(IllegalStateException.class);
    }
}