package stringcalcaulator.domain.token;

public interface ExpressionTokenResolver {
    boolean supports(String token);
    ExpressionToken resolve(String token);
}
