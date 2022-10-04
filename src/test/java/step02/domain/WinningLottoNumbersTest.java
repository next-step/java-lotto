package step02.domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoNumbersTest {

    @Test
    @DisplayName("로또 번호와 보너스 볼 넘버가 중복되는 경우 에러 발생.")
    void validateIsDuplicated() {
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLottoNumbers(Lotto.of(List.of(1, 2, 3, 4, 5, 7)), new LottoNumber(1)));
    }
}