package domain;

import java.util.ArrayList;
import java.util.List;

public class Tokens {
    private final List<String> tokens;

    public Tokens(String tokenString) {
        if (!validateString(tokenString)) {
            throw new IllegalArgumentException("Invalid String");
        }
        this.tokens = new ArrayList<>(List.of(splitTokens(tokenString)));
    }

    private Boolean validateString(String tokenString) {
        return tokenString != null && !tokenString.isEmpty();
    }

    public String getToken(int index) {
        return tokens.get(index);
    }

    public Integer size() {
        return tokens.size();
    }

    public void addToken(String token) {
        tokens.add(token);
    }

    private String[] splitTokens(String tokenString) {
        return tokenString.split(" ");
    }
}
