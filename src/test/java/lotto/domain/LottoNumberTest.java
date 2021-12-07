package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    public void 정상_생성자() {
        assertThat(new LottoNumber(5).getLottoNumber()).isEqualTo(5);
    }

    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {-1, 0, 46})
    public void 입력_범위와_다른_숫자(int param) {
        assertThatThrownBy(() -> {
            new LottoNumber(param);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(strings = {"ONE", "하나"})
    public void 한글_생성자(String param) {
        assertThatThrownBy(() -> {
            new LottoNumber(param);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
