package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class IntegerTest {

    @Test
    void 모듈러_더큰수로() {
        assertThat(3 % 4).isEqualTo(3);
    }

    @Test
    void 파싱_마이너스_제로() {
        assertThat(Integer.parseInt("-0")).isEqualTo(0);
    }

}
