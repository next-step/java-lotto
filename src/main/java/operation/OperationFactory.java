package operation;

import operation.implemantation.DivideOperation;
import operation.implemantation.MinusOperation;
import operation.implemantation.MultiplyOperation;
import operation.implemantation.PlusOperation;

public class OperationFactory {
    public static Operation make(String stringOperation) {
        if (stringOperation.equals("+")) {
            return new PlusOperation();
        }

        if (stringOperation.equals("-")) {
            return new MinusOperation();
        }

        if (stringOperation.equals("*")) {
            return new MultiplyOperation();
        }

        if (stringOperation.equals("/")) {
            return new DivideOperation();
        }

        throw new IllegalArgumentException("사칙연산만 실행 가능합니다.");
    }
}
