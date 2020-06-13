package lotto.domain.lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {
    @Test
    void 생성_테스트() {
        assertThatCode(() -> LottoNumber.create(1)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 생성범위_확인(int lottoNumber) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.create(lottoNumber))
                .withMessageContaining("입력 값이 유효하지 않습니다.");
    }
}
