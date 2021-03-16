package step1.domain;

public class Operator {

    public int totalSum(Tokens tokens) {
        return tokens.getReadOnlyTokens()
                .stream()
                .mapToInt(Token::getToken)
                .sum();
    }
}
