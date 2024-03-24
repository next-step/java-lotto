package step1.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operators {

    private static final Pattern patternOperate = Pattern.compile("[^\\w\\s]");

    private final List<Operator> operators = new ArrayList<>();

    public Operators(String string) {
        Matcher matcher = patternOperate.matcher(string);
        while (matcher.find()) {
            operators.add(Operator.fromString(matcher.group()));
        }
    }

    public List<Operator> getOperators() {
        return operators;
    }

}
