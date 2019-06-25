import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringElementParser {
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

    private List<String> separators = createDefaultSeparators();
    private String string;

    public StringElementParser(String string) {
        Matcher matcher = PATTERN.matcher(string);
        if (matcher.find()) {
            separators.add(matcher.group(1));
            this.string = matcher.group(2);
            return;
        }
        this.string = string;
    }

    public void parseElement(Consumer<String> elementConsumer) {
        String tokenCondition = String.join("|", separators);

        StringTokenizer tokenizer = new StringTokenizer(string, tokenCondition);
        while (tokenizer.hasMoreTokens()) {
            String element = tokenizer.nextToken();
            elementConsumer.accept(element);
        }
    }

    private static List<String> createDefaultSeparators() {
        List<String> separators = new ArrayList<>();
        separators.add(":");
        separators.add(",");
        return separators;
    }
}
