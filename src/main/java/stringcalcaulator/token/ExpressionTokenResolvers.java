package stringcalcaulator.token;

import java.util.Arrays;
import java.util.List;

public class ExpressionTokenResolvers {

    private static final List<ExpressionTokenResolver> RESOLVERS = Arrays.asList(
        new OperatorTokenResolver(),
        new OperandTokenResolver()
    );

    public static ExpressionToken resolve(String token) {
        for (ExpressionTokenResolver resolver : RESOLVERS) {
            if (resolver.supports(token)) {
                return resolver.resolve(token);
            }
        }

        throw new IllegalArgumentException("숫자 또는 연산자만 입력이 가능합니다.");
    }

}
