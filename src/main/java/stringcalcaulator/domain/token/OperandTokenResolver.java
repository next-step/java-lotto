package stringcalcaulator.domain.token;

public class OperandTokenResolver implements ExpressionTokenResolver {

    @Override
    public boolean supports(String token) {
        return token.matches("^\\d+$");
    }

    @Override
    public ExpressionToken resolve(String token) {
        return new OperandToken(Integer.parseInt(token));
    }
}
