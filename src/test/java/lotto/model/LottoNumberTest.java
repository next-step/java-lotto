package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 범위밖의_번호로_로또_구성시_오류(int outOfRangeNumber) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoNumber(outOfRangeNumber)
        ).withMessageContaining("번호는 1~45사이의 자연수입니다.");
    }

}
