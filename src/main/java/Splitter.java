import java.util.ArrayList;
import java.util.List;

public class Splitter {

    public OperationNumbers splitOperationNumbers(String value) {
        String[] split = value.split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (int idx = 0; idx < split.length; idx += 2) {
            numbers.add(Integer.parseInt(split[idx]));
        }

        return new OperationNumbers(numbers);
    }

    public List<Operator> splitOperators(String value) {
        String[] split = value.split(" ");
        List<String > stringOperators = new ArrayList<>();
        for (int idx = 1; idx < split.length; idx += 2) {
            stringOperators.add(split[idx]);
        }

        return Operator.byStringOperators(stringOperators);
    }
}
