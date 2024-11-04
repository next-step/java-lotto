package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import lotto.domain.LottoNumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0,46})
    public void 숫자범위1_45이외_테스트(int testLottoNumber) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumber lottoNumber = new LottoNumber(testLottoNumber);
        });

    }

}
