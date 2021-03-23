package step1.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("Number 인스턴스 음수 입력시 예외처리 여부 테스트")
    @Test
    void 검증() {
        // given
        int inputValue = -1;

        // when and then
        assertThatThrownBy(()->{
            () -> assertThat(new Number(inputValue)).isNotNull();
        }).isInstanceOf(NegativeNumberException.class);

    }
}