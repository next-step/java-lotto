package operation;

import operation.implemantation.DivideOperation;
import operation.implemantation.MinusOperation;
import operation.implemantation.MultiplyOperation;
import operation.implemantation.PlusOperation;

public class OperationFactory {

    public static int calculateRightNow(int result, int number, String stringOperation) {
        if (stringOperation.equals("+")) {
            PlusOperation plusOperation = new PlusOperation();
            return plusOperation.calculate(result,number);
        }

        if (stringOperation.equals("-")) {
            MinusOperation minusOperation = new MinusOperation();
            return minusOperation.calculate(result, number);
        }

        if (stringOperation.equals("*")) {
            MultiplyOperation multiplyOperation = new MultiplyOperation();
            return multiplyOperation.calculate(result, number);
        }

        if (stringOperation.equals("/")) {
            DivideOperation divideOperation = new DivideOperation();
            return divideOperation.calculate(result, number);
        }

        throw new IllegalArgumentException("사칙연산만 실행 가능합니다.");
    }
}
