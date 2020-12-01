package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FeeTest {

    @Test
    @DisplayName(value = "Fee 생성 테스트")
    void create() {
        Fee fee = new Fee(1000);

        assertThat(fee).isNotNull();
    }

    @Test
    @DisplayName(value = "천원보다 낮은 금액을 입력하면 IllegalArgumentException 발생함.")
    void lessMoney_shouldIllegalArgumentException() {
        assertThatThrownBy(() -> new Fee(999)).isInstanceOf(IllegalArgumentException.class);
    }
}