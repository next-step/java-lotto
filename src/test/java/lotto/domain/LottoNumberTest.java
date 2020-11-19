package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {

    @DisplayName("LottoNumber 생성 테스트")
    @Test
    void of1() {
        assertThat(LottoNumber.of(13))
                .isEqualToComparingFieldByField(LottoNumber.of(13));
    }

    @DisplayName("LottoNumber 생성 테스트 : 숫자 validate 체크")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 100})
    void of2(int num) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNumber.of(num);
        });
    }
}
