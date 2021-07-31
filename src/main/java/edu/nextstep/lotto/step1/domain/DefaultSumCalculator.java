package edu.nextstep.lotto.step1.domain;

import edu.nextstep.lotto.step1.vo.TokenNumber;
import edu.nextstep.lotto.step1.vo.Tokens;

public class DefaultSumCalculator implements SumCalculator {

    @Override
    public int sum(Tokens tokens) {
        return tokens.getTokens().stream()
                .mapToInt(token -> new TokenNumber(token).getNumber())
                .sum();
    }
}
