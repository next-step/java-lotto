import java.util.*;
import java.util.stream.*;

public class Calculator {
    private List<String> values;

    public Calculator() {
        this("");
    }

    public Calculator(String input) {
        inputEmptyCheck(input);

        this.values = Stream.of(input.split(" "))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private void inputEmptyCheck(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력 문자열이 빈 값 입니다.");
        }
    }

    public int result() {
        while (this.values.size() != 1) {
            initAndCalculate();
        }

        return Integer.parseInt(this.values.get(0));
    }

    private void initAndCalculate() {
        int result = 0;
        Operator operator = new Operator(Integer.parseInt(this.values.remove(0)), this.values.remove(0), Integer.parseInt(this.values.remove(0)));

        result = operator.operate();

        this.values.add(0, String.valueOf(result));
    }
}
