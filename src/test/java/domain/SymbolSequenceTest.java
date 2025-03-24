package domain;

import domain.symbol.Operator;
import domain.symbol.SymbolSequence;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SymbolSequenceTest {

    @DisplayName("Operators 내에 남은 연산자 존재 여부 확인")
    @Test
    void hasNextOperatorTest() {
        // Given
        SymbolSequence<Operator> operators = new SymbolSequence<>();
        operators.add(new Operator("+"));
        operators.add(new Operator("-"));
        operators.add(new Operator("*"));
        operators.add(new Operator("/"));

        // When
        boolean[] actualResults = new boolean[]{
                operators.hasNext(),
                getNextOperatorAndCheck(operators),
                getNextOperatorAndCheck(operators),
                getNextOperatorAndCheck(operators),
                getNextOperatorAndCheck(operators)
        };

        // Then
        boolean[] expectedResults = new boolean[]{true, true, true, true, false};
        Assertions.assertThat(actualResults).containsExactly(expectedResults);
    }

    private boolean getNextOperatorAndCheck(SymbolSequence<Operator> operators) {
        operators.getNext();
        return operators.hasNext();
    }
}