package study.lotto.step1.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class OperationResult {
    private final BigDecimal result;

    public OperationResult(String result) {
        this(new BigDecimal(result));
    }

    public OperationResult(BigDecimal result) {
        this.result = result;
    }

    public Operand operand() {
        return new Operand(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationResult that = (OperationResult) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }
}
