package calculator.domain;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Values {

    private final List<Value> values;

    public Values(String[] splitString) {
        values = Arrays.stream(splitString)
                .map(Value::new)
                .collect(toList());
    }

    public int sum() {
      return values.stream().map(Value::getNumber)
              .reduce(0,Integer::sum);
    }
}
