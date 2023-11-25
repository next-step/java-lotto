package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @Test
    @DisplayName("1~45 범위를 벗어나는 숫자 생성 시 에러 발생")
    public void validate_로또_번호_범위() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumber(46);
        });
    }
}
