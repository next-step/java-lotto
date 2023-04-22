package calculator.domain;

import calculator.domain.extractor.Extractor;

import java.util.List;

public class OperatorGroup {

    private final OperatorGroupOffset offset;
    private final List<Operator> operatorList;

    private OperatorGroup(OperatorGroupOffset offset, List<Operator> operatorList) {
        this.offset = offset;
        this.operatorList = operatorList;

    }

    public static OperatorGroup of(OperatorGroupOffset offset, Extractor<List<Operator>> extractor, List<String> input) {
        return new OperatorGroup(offset, extractor.extract(input));
    }

    public Operator provideOperator() {
        int currentOffset = offset.increaseAndGet();

        if (currentOffset > operatorList.size()) {
            return Operator.SELF_MULTIPLICATION;
        }

        return operatorList.get(currentOffset);
    }

    public int operatorExecute(Operator operator, int leftOperand, int rightOperand) {
        return Operator.calculate(operator, leftOperand, rightOperand);
    }

}
