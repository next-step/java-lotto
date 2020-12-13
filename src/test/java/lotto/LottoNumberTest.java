package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTest {
    
    @DisplayName("로또 번호 생성시 1 ~ 45 의 범위를 벗어나면 오류")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 100})
    public void lottoGenerate(int failureNumber) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber(failureNumber))
                .withMessageMatching("로또 숫자는 1 ~ 45 사이의 숫자만 가능합니다.");
    }
}
