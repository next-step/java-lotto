import operation.Operater;
import operation.Operation;
import operation.OperationFactory;
import operation.implemantation.DivideOperation;
import operation.implemantation.PlusOperation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OperationFactoryTest {
    @Test
    @DisplayName("더하기 책임 객체 만들기")
    void make_plus_operations()  {
        // given
        String operations = "+";

        // when
        Operation plusOperations = OperationFactory.make(operations);

        // then
        Assertions.assertInstanceOf(PlusOperation.class,plusOperations);
    }

    @Test
    @DisplayName("사칙연산이 아닐 경우 예외 발생")
    void nothing_operations()  {
        // given
        String operations = " ";

        // then
        assertThrows(IllegalArgumentException.class, () -> Operater.defaultOf(operations));
    }
}
