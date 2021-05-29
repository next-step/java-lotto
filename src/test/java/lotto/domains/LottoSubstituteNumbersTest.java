package lotto.domains;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoSubstituteNumbersTest {
    @Test
    void 여섯개의_로또번호_반환_테스트() {
        assertThat(LottoSubstituteNumbers.sixLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    void 로또후보번호_불변객체_테스트() {
        assertThrows(UnsupportedOperationException.class, () ->LottoSubstituteNumbers.sixLottoNumbers().add(100));
    }
}
