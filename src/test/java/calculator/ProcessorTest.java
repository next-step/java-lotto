package calculator;

import calculator.domain.Processor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProcessorTest {

    @Test
    public void calculate(){
        Processor processor = new Processor();
        assertThat(processor.calculate("//;\\n1;2;3"))
                .isEqualTo(6);
    }
}
