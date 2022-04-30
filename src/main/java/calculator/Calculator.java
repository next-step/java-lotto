package calculator;

import calculator.domain.Element;
import calculator.domain.ElementBuilder;
import calculator.domain.NumberElement;
import calculator.domain.Operator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Calculator {
    public static int start(String formula) {
        List<String> elements = List.of(formula.split(" "));

        return execute(elements);
    }

    public static int execute(List<String> elements) {
        Queue<Element> es = new LinkedList<>();
        for (String element: elements) {
            es.add(ElementBuilder.of(element));
        }

        NumberElement result = (NumberElement) es.poll();
        while (!es.isEmpty()) {
            Operator operator = (Operator) es.poll();
            NumberElement b = (NumberElement) es.poll();

            result = operator.execute(result, b);
        }

        return result.getValue();
    }
}
