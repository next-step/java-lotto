package stringcalcaulator.domain.token;

import java.util.Arrays;

public class OperatorTokenResolver implements ExpressionTokenResolver {

    @Override
    public boolean supports(String token) {
        return Arrays.stream(OperatorToken.values())
            .anyMatch(operatorToken -> operatorToken.getSymbol().equals(token));
    }

    @Override
    public ExpressionToken resolve(String token) {
        return Arrays.stream(OperatorToken.values())
            .filter(operatorToken -> operatorToken.getSymbol().equals(token))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("해당 연산자를 찾을 수 없습니다."));
    }
}
