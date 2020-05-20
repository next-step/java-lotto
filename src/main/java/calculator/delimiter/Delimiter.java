package calculator.delimiter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
public interface Delimiter {

    List<String> split(List<String> expressions);

    default List<String> splitByDelimiter(List<String> expressions, String delimiter){
        List<String> results = new ArrayList<>();
        for (String expression : expressions) {
            List<String> splitResult = Arrays.asList(expression.split(delimiter));
            results.addAll(splitResult);
        }
        return results;
    }
}
