package domain;

import domain.extractor.Extractor;
import domain.extractor.OperatorExtractor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperatorGroupTest {

    private OperatorGroup operatorGroup = getOperatorGroup();
    private List<Operator> operatorList = List.of(Operator.ADDITION, Operator.MULTIPLICATION, Operator.DIVISION);

    @RepeatedTest(value = 3)
    @DisplayName("연산자 제공 테스트")
    void operatorProvideTest(RepetitionInfo repetitionInfo) {

        Operator operator = getOperator(repetitionInfo);

        assertEquals(operator, operatorList.get(repetitionInfo.getCurrentRepetition() - 1));
    }

    private Operator getOperator(RepetitionInfo repetitionInfo) {
        int currentRepetitionInfo = repetitionInfo.getCurrentRepetition();
        return IntStream.range(0, currentRepetitionInfo).mapToObj(repetition -> operatorGroup.provideOperator()).collect(Collectors.toList()).get(currentRepetitionInfo - 1);

    }

    private OperatorGroup getOperatorGroup() {
        Extractor operatorExtractor = new OperatorExtractor();
        return OperatorGroup.of(
                OperatorGroupOffset.initialize(),
                operatorExtractor,
                List.of("2", "+", "3", "*", "4", "/", "2")
        );
    }
}