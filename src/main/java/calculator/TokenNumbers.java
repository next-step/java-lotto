package calculator;

import java.util.List;
public class TokenNumbers {

    final private List<TokenNumber> tokenNumbers;

    public TokenNumbers(List<TokenNumber> tokenNumbers) {
        this.tokenNumbers = tokenNumbers;
    }

    public long sum() {
        return tokenNumbers.stream()
            .map(TokenNumber::getValue)
            .reduce(0L, Long::sum);
    }
}
