package stringcalcaulator.token;

import stringcalcaulator.ExpressionTokenVisitor;

public interface ExpressionToken {
    void accept(ExpressionTokenVisitor visitor);
}
