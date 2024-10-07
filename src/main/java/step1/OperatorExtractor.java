package step1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class OperatorExtractor {

    public static Queue<String> extract(String[] values) {
        return Arrays.stream(values).filter(StringCalculator::isOperator)
                .collect(Collectors.toCollection(LinkedList::new));
    }

}
