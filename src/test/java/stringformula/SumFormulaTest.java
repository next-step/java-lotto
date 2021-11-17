package stringformula;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SumFormulaTest {

    @Test
    @DisplayName("of 메소드는 SumFormula 객체를 생성한다")
    public void 테스트_of_메소드_객체_생성() {
        assertNotNull(SumFormula.of("1,2:3"));
    }

    @Test
    @DisplayName("result 메소드는 수식으로부터 총합 결과를 반환한다")
    public void 테스트_result_메소드_총합_결과_반환() {
        assertThat(SumFormula.of("\\;1;2;3").result()).isEqualTo(new Number(6));
    }
}