package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class LottoTest {
    @Test
    @DisplayName("로또 번호에 대한 유효성 테스트")
    void validLottoNumbers() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(1,2,3));
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(0,1,2,3,4,5));
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
           new Lotto(Arrays.asList(1,2,3,4,5,46));
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
           new Lotto(Arrays.asList(1,2,3,4,5,5));
        });
    }
}