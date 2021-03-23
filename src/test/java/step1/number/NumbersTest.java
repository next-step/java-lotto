package step1.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NumbersTest {

    @DisplayName("Numbers 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {
        // given
        List<Number> inputData = new ArrayList<Number>();

        // when
        Numbers numbers = new Numbers(inputData);

        // then
        assertThat(numbers).isNotNull();

    }

    @DisplayName("Numbers 인스턴스 생성시 Null 값 입력시 예외처리 발생 여부 테스트")
    @Test
    void 검증() {
        // given
        List<Number> inputData = null;

        // when and then
        assertThatThrownBy(() -> {
            new Numbers(inputData);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null 값을 입력했습니다.");

    }

}