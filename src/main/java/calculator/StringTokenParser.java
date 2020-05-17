package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringTokenParser implements TokenParser {

    @Override
    public TokenNumbers parseTokenNumbers(String input) {
        String tokens = input;
        String splitter = ",|:";

        Pattern pattern = Pattern.compile("//(.)\\n(.*)");
        Matcher matcher = pattern.matcher(input);
        if(matcher.matches()){
            splitter =  matcher.group(1);
            tokens = matcher.group(2);
        }

        return getTokenNumbers(splitter, tokens);
    }

    private TokenNumbers getTokenNumbers(String splitter, String tokens) {
        List<TokenNumber> tokenNumbers= Stream.of(tokens.split(splitter))
            .map(token -> TokenNumber.of(token))
            .collect(Collectors.toList());

        return new TokenNumbers(tokenNumbers);
    }
}
