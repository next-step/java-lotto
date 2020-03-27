package calculate.domain;

import calculate.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DelimiterStrategy {
    private final Operands operands;
    private final Delimiter delimiter;

    public DelimiterStrategy(String operandString, String delimiterString) {
        this.delimiter = new Delimiter(delimiterString);

        List<String> delimitedString = splitOperandString(operandString);
        this.operands = new Operands(makeOperands(delimitedString));
    }

    private List<String> splitOperandString(String inputString) {
        if (Objects.isNull(inputString) || inputString.isEmpty()) {
            return Arrays.asList("0");
        }
        return StringUtil.splitStringUseDelimiter(inputString, delimiter.getDelimiter());
    }

    private List<Operand> makeOperands(List<String> delimitedString) {
        List<Operand> result = new ArrayList<>();
        for (String str : delimitedString) {
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
            throw new RuntimeException("숫자를 입력해 주세요");
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
