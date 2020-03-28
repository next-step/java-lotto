package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 9})
    @DisplayName("로또 숫자 생성 테스트")
    void generateLottoNumberTest(int value) {
        assertThat(
                new LottoNumber(() -> value).getLottoNumber()
        ).isEqualTo(value);
    }
}
