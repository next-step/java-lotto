package step1_caculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1_caculator.domain.CalculationExecutor;
import step1_caculator.domain.SequenceProcessor;

import java.util.List;

public class SequenceProcessorTest {
    @DisplayName("입력에 따른 순차 계선을 진행한다.")
    @Test
    void process(){
        List<String> inputs = List.of("5", "+", "3", "/", "2");
        CalculationExecutor calculationExecutor = new CalculationExecutor();
        SequenceProcessor sut = new SequenceProcessor(calculationExecutor);

        Assertions.assertThat(sut.process(inputs)).isEqualTo(4);
    }

    @DisplayName("연산자가 연속으로 올 경우 마지막 연산자만 취한다.")
    @Test
    void process_repeated_operator(){
        List<String> inputs = List.of("5", "+", "-", "3");
        CalculationExecutor calculationExecutor = new CalculationExecutor();
        SequenceProcessor sut = new SequenceProcessor(calculationExecutor);

        Assertions.assertThat(sut.process(inputs)).isEqualTo(2);
    }

    @DisplayName("숫자가 연속으로 올 경우 숫자부터 결과가 리셋된다.")
    @Test
    void process_repeated_number(){
        List<String> inputs = List.of("5", "-", "3", "4");
        CalculationExecutor calculationExecutor = new CalculationExecutor();
        SequenceProcessor sut = new SequenceProcessor(calculationExecutor);

        Assertions.assertThat(sut.process(inputs)).isEqualTo(4);
    }

    @DisplayName("숫자가 연속으로 온 뒤 연산이 추가로 진행될 경우, 리셋된 숫자부터 다시 시작한다/.")
    @Test
    void process_repeated_number_2(){
        List<String> inputs = List.of("5", "-", "3", "4", "+", "1");
        CalculationExecutor calculationExecutor = new CalculationExecutor();
        SequenceProcessor sut = new SequenceProcessor(calculationExecutor);

        Assertions.assertThat(sut.process(inputs)).isEqualTo(5);
    }
}
