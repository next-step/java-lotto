package step1.util;

import java.util.Arrays;

public enum ParserGroup {
    CUSTOM(new CustomParser()),
    DEFAULT(new DefaultParser());

    private ParseStrategy parseStrategy;

    ParserGroup(ParseStrategy parseStrategy) {
        this.parseStrategy = parseStrategy;
    }

    public static ParseStrategy findStrategyByInput(String input) {
        return Arrays.stream(values())
                .filter(strategy -> strategy.support(input))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .getParseStrategy();
    }

    public ParseStrategy getParseStrategy() {
        return parseStrategy;
    }

    private boolean support(String input) {
        return this.parseStrategy.support(input);
    }
}
