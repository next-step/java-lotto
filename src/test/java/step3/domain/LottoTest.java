package step3.domain;

import org.junit.jupiter.api.Test;
import step3.domain.lotto.Lotto;
import step3.domain.lotto.LottoNumber;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


class LottoTest {

    @Test
    void 로또_생성_기능() {
        // Given && When
        List<LottoNumber> givenLottoNumber = Arrays
            .asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

        // When
        Lotto lotto = Lotto.create(givenLottoNumber);

        // Then
        assertThat(lotto.numbers()).isEqualTo(givenLottoNumber);
    }


}
