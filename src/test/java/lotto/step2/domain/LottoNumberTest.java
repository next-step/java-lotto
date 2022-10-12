package lotto.step2.domain;

import lotto.step2fixture.domain.LottoNumberFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @Test
    @DisplayName("로또 번호 생성")
    void create() {
        assertThat(LottoNumberFixture.ONE).isNotNull();
    }
    
    @ParameterizedTest(name = "{displayName} : {0}")
    @DisplayName("로또 번호 범위 벗어날 시 예외")
    @ValueSource(ints = {0, 46})
    void exceeded_exception(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(input))
                .withMessage("로또번호 범위를 초과하였습니다.");
    }
}