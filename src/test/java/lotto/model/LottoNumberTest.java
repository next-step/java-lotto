package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @ParameterizedTest
    @DisplayName("1~45 범위를 벗어나는 숫자 생성 시 에러 발생")
    @ValueSource(ints = {0, 46})
    public void validate_로또_번호_범위(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(number);
        }).withMessageMatching("Lotto numbers should by between 1 and 45. \\d+ is an invalid value.");
    }
}
