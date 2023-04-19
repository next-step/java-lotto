package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OperatorGroupOffsetTest {

    @Test
    @DisplayName("연산자 그룹 offset은 초기 값으로 0을 반환한다")
    void initialize(){

        assertThat(OperatorGroupOffset.initialize()).isEqualTo(new OperatorGroupOffset(0));
    }

}