package calculator;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringTokenParser implements TokenParser {

    private static final Pattern STRING_TOKEN_PATTERN = Pattern.compile("//(.)\\n(.*)");
    private static final String DEFAULT_SPLITTER = ",|:";

    @Override
    public TokenNumbers parseTokenNumbers(String input) {
        String tokens = input;
        String splitter = DEFAULT_SPLITTER;

        Matcher matcher = STRING_TOKEN_PATTERN.matcher(input);
        if (matcher.matches()) {
            splitter = matcher.group(1);
            tokens = matcher.group(2);
        }

        return getTokenNumbers(splitter, tokens);
    }

    private TokenNumbers getTokenNumbers(String splitter, String tokens) {
        if (tokens.isEmpty()) {
            return new TokenNumbers(Collections.EMPTY_LIST);
        }

        List<TokenNumber> tokenNumbers = Stream.of(tokens.split(splitter))
            .map(token -> TokenNumber.of(token))
            .collect(Collectors.toList());

        return new TokenNumbers(tokenNumbers);
    }
}
