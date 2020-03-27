package calculate.domain;

import calculate.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DelimiterStrategy {
    private final Operands operands;
    private final Delimiter delimiter;

    public DelimiterStrategy(String primalOperand, String delimiter) {
        this.delimiter = new Delimiter(delimiter);

        List<String> delimitedString = splitOperandString(primalOperand);
        this.operands = new Operands(makeOperands(delimitedString));
    }

    private List<String> splitOperandString(String primalOperand) {
        if (Objects.isNull(primalOperand) || primalOperand.isEmpty()) {
            return Arrays.asList("0");
        }
        return StringUtil.splitStringUseDelimiter(primalOperand, delimiter.getDelimiter());
    }

    private List<Operand> makeOperands(List<String> operands) {
        List<Operand> result = new ArrayList<>();
        for (String str : operands) {
            result.add(createOperand(str));
        }
        return result;
    }

    private Operand createOperand(String str) {
        if (isNullOrEmpty(str)) {
            return new Operand();
        }

        try {
            return new Operand(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요");
        }
    }

    private boolean isNullOrEmpty(String str) {
        return (Objects.isNull(str) || str.trim().isEmpty());
    }

    public Operands getOperands() {
        return operands;
    }

    public Delimiter getDelimiter() {
        return delimiter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DelimiterStrategy that = (DelimiterStrategy) o;
        return Objects.equals(operands, that.operands);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operands);
    }
}
