package step2.domain;

import org.junit.jupiter.api.Test;
import step2.domain.lotto.Lotto;
import step2.domain.lotto.LottoNumber;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class LottoTest {

    @Test
    void 로또_생성_기능() {
        // Given && When
        LottoNumber givenLottoNumber = new LottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));

        // When
        Lotto lotto = Lotto.create(givenLottoNumber);

        // Then
        assertThat(lotto.numbers()).isEqualTo(givenLottoNumber);
    }
}
