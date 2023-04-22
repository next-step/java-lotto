package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorGroupOffsetTest {

    @Test
    @DisplayName("연산자 그룹 offset은 초기 값으로 0을 반환한다")
    void initialize() {

        assertThat(OperatorGroupOffset.initialize()).isEqualTo(new OperatorGroupOffset(0));
    }

    @Test
    @DisplayName("연산자 그룹 offset은 offset증가하는 메소드 호출시 offset이 증가한다")
    void increase() {

        assertThat(OperatorGroupOffset.initialize().increaseAndGet()).isEqualTo(0);
    }

}