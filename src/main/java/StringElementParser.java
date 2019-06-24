import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Consumer;

public class StringElementParser {
    private List<String> separators = Arrays.asList(",", ":");
    private String string;

    public StringElementParser(String string) {
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
}
