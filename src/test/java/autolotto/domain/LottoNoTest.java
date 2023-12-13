package autolotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNoTest {
    @Test
    @DisplayName("로또 숫자 범위 초과 시 exception 확인")
    void lottoNo_로또숫자범위확인(){
        assertThatThrownBy(() ->new LottoNo(47)).isInstanceOf(IllegalArgumentException.class);
    }

}
