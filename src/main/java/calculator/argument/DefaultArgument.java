package study.calculator.argument;

import study.calculator.Delimiter;
import study.calculator.Number;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultArgument implements Argument{

    private static final Delimiter COMMA = new Delimiter(",");
    private static final Delimiter COLON = new Delimiter(":");

    private final String body;

    public DefaultArgument(String body) {
        this.body = body;
    }

    @Override
    public List<Number> parseToNumber() {
        String[] fragments = body.replaceAll(COLON.getValue(), COMMA.getValue())
                .split(COMMA.getValue());
        return Arrays.asList(fragments)
                .stream()
                .map(Number::of)
                .collect(Collectors.toList());
    }
}
