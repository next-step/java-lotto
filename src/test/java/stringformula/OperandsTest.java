package stringformula;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class OperandsTest {

    @Test
    @DisplayName("sumAll 메소드는 피연산자들의 총합을 반환한다")
    public void 테스트_sumAll_메소드_총합_결과_반환() {
        Operands operands = new Operands(Arrays.asList(new Number(1),
                new Number(2), new Number(3)));
        assertThat(operands.sumAll()).isEqualTo(new Number(6));
    }
}
