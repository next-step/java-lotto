package stringcalcaulator.domain.token;

import stringcalcaulator.domain.ExpressionTokenCalculatorVisitor;

public interface ExpressionToken {
    void accept(ExpressionTokenCalculatorVisitor visitor);
}
