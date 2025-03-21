package stringcalcaulator.domain.token;

import stringcalcaulator.domain.ExpressionTokenVisitor;

public interface ExpressionToken {
    void accept(ExpressionTokenVisitor visitor);
}
