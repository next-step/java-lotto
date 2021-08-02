package step2;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class LottoTest {

    @Test
    void 로또를_만든다() {
        // Given && When
        LottoNumber givenLottoNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));

        // When
        Lotto lotto = Lotto.create(givenLottoNumber);

        // Then
        assertThat(lotto.numbers()).isEqualTo(givenLottoNumber);
    }
}
