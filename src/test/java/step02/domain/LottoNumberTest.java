package step02.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @DisplayName("생성자 테스트")
    @Test
    public void test_LottoNumber_Constructor() {
        assertThat(LottoNumber.of(1)).isEqualTo(LottoNumber.of(1));
    }

}
