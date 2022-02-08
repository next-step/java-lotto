package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class AdderTest {
    
    @Test
    void 더하기() {
        List<Operand> tokens = Arrays.asList(
          new Operand("1"),
          new Operand("2"),
          new Operand("3")
        );
        
        Adder adder = new Adder(tokens);
        int result = adder.calculate();
        
        assertThat(6).isEqualTo(result);
    }
    
    @Test
    void 숫자_하나를_입력했을_때_입력된_숫자만_반환한다() {
        List<Operand> tokens = Arrays.asList(
          new Operand("1")
        );
        
        Adder adder = new Adder(tokens);
        int result = adder.calculate();
        
        assertThat(1).isEqualTo(result);
    }
}
