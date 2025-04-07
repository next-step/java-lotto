package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoNumbersTest {

    @Test
    @DisplayName("로또 번호가 중복될 시 IllegalArgumentException 이 발생한다.")
    void 로또_번호_리스트_중복_테스트() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(List.of(1, 2, 3, 4, 5, 5)));
    }
}