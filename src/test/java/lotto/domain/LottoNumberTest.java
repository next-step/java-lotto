package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberTest {

    @Test
    void 숫자_문자동일_확인() {
        LottoNumber lottoNumber = LottoNumber.from("1");
        assertThat(lottoNumber).isEqualTo(LottoNumber.from(1));
    }

    @Test
    void 로또번호_확인() {
        LottoNumber lottoNumber = LottoNumber.from("1");
        assertThat(lottoNumber.getLottoNumber()).isEqualTo(1);
    }

    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {-1, 0, 46})
    void 숫자_1이상_45이하의_입력시_IllegalArgumentException(int param) {
        assertThatThrownBy(() -> {
            LottoNumber.from(param);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(strings = {"ONE", "하나"})
    void 문자_오입력시_IllegalArgumentException(String param) {
        assertThatThrownBy(() -> {
            LottoNumber.from(param);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
