package calculator.domain;

import calculator.domain.extractor.Extractor;

import java.util.List;

public class OperandGroup {
    private final List<Integer> operandList;
    private final OperandGroupOffset offset;

    private OperandGroup(OperandGroupOffset offset, List<Integer> operandList) {
        this.operandList = operandList;
        this.offset = offset;
    }

    public static OperandGroup of(OperandGroupOffset offset, Extractor<List<Integer>> extractor, List<String> input) {
        return new OperandGroup(offset, extractor.extract(input));
    }

    public boolean isContinue() {
        return offset.isLastOffset(operandList.size() - 1);
    }

    public int provideOperand() {
        int currentOffset = offset.increaseAndGet();

        return operandList.get(currentOffset);
    }
}
