package step1;

import java.util.ArrayList;
import java.util.List;

public class Tokens {
    private final List<String> tokens;

    public Tokens(String tokenString, String delimiter) {
        if (!validateString(tokenString)) {
            throw new IllegalArgumentException("Invalid String");
        }
        this.tokens = new ArrayList<>(List.of(splitTokens(tokenString, delimiter)));
    }

    private Boolean validateString(String tokenString) {
        return tokenString != null && !tokenString.isBlank();
    }

    public String getToken(int index) {
        return tokens.get(index);
    }

    public Integer size() {
        return tokens.size();
    }

    private String[] splitTokens(String tokenString, String delimiter) {
        return tokenString.split(delimiter);
    }
}
