package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class ParserTest {
    
    @Test
    void 기본구분자_테스트() {
        assertThat(Parser.parseInput("1,2,3")).isEqualTo
          (Arrays.stream(new String[]{"1", "2", "3"}).map(Operand::new)
            .collect(Collectors.toList()));
    }
    
    @Test
    void 커스텀구분자_테스트() {
        assertThat(Parser.parseInput("//;\n1;2;3")).isEqualTo
          (Arrays.stream(new String[]{"1", "2", "3"}).map(Operand::new)
            .collect(Collectors.toList()));
    }
}
