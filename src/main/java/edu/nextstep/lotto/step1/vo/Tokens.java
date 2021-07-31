package edu.nextstep.lotto.step1.vo;

import java.util.Arrays;
import java.util.List;

public class Tokens {

    private final List<String> tokens;

    public Tokens(String[] tokens) {
        this.tokens = Arrays.asList(tokens);
    }

    public Tokens(List<String> tokens) {
        this.tokens = tokens;
    }

    public List<String> getTokens() {
        return tokens;
    }
}
