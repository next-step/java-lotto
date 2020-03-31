package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.LottoProvider;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {

    @Test
    @DisplayName("입력받은 보너스 번호가 로또 번호와 중복되지 않아야 함을 검증한다.")
    void validateWinningLotto() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoProvider.createWinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 6);
        });
    }
}
