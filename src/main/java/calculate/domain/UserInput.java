package calculate.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInput {
    private static final Pattern p = Pattern.compile("\\/\\/(.)\\\\n(.*)");
    String primaloperand;
    String delimiter;

    public UserInput(String userInput) {
        parse(userInput);
    }

    public void parse(String userInput) {
        Matcher m = p.matcher(userInput);

        if (m.find()) {
            delimiter = m.group(1);
            primaloperand = m.group(2);
        }
    }

    public String getPrimaloperand() {
        return primaloperand;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
