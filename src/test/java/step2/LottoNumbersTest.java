package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외가 발생한다")
    @Test
    void newInstance_LottoNumbers_ExceptionThrown() {
        assertThatThrownBy(() -> LottoNumbers.newInstance(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호 개수가 일치하지 않습니다");
    }
}
