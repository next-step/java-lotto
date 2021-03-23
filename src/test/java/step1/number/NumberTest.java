package step1.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {

    @DisplayName("Number 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        int inputValue = 1;

        // when
        Number number = new Number(inputValue);

        // then
        assertThat(number).isNotNull();
    }
}