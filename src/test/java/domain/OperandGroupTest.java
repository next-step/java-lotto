package domain;

import calculator.domain.OperandGroup;
import calculator.domain.OperandGroupOffset;
import calculator.domain.extractor.Extractor;
import calculator.domain.extractor.OperandExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperandGroupTest {


    private OperandGroup operandGroup = getOperandGroup();
    private List<Integer> operatorList = List.of(2, 3, 4, 2);

    @RepeatedTest(value = 3)
    @DisplayName("피연산자 제공 테스트")
    void operandProvideTest(RepetitionInfo repetitionInfo) {

        int operator = getOperandP(repetitionInfo);

        assertEquals(operator, operatorList.get(repetitionInfo.getCurrentRepetition() - 1));
    }

    private int getOperandP(RepetitionInfo repetitionInfo) {
        int currentRepetitionInfo = repetitionInfo.getCurrentRepetition();
        return IntStream.range(0, currentRepetitionInfo).mapToObj(repetition -> operandGroup.provideOperand()).collect(Collectors.toList()).get(currentRepetitionInfo - 1);

    }

    private OperandGroup getOperandGroup() {
        Extractor operandExtractor = new OperandExtractor();
        return OperandGroup.of(
                OperandGroupOffset.initialize(),
                operandExtractor,
                List.of("2", "+", "3", "*", "4", "/", "2")
        );
    }

}