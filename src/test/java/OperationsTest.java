import operation.Operation;
import operation.Operations;
import operation.implemantation.MultiplyOperation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class OperationsTest {

    @Test
    @DisplayName("operation.Operations 생성")
    void writingMethodName() {
        // given
        List<String> operationsStrings = new ArrayList<>();
        operationsStrings.add("+");
        operationsStrings.add("*");
        Operations operations = Operations.defaultOf(operationsStrings);

        // when
        Operation operation = operations.nextOperation();
        Operation testTarget = operations.nextOperation();

        // then
        Assertions.assertInstanceOf(MultiplyOperation.class, testTarget);
    }


}
