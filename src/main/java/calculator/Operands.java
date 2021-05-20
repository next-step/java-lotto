package calculator;

import java.util.ArrayList;
import java.util.List;

public class Operands {

    private final List<Operand> operands;

    public Operands(String[] numbers) {
        operands = createOperands(numbers);
    }

    private List<Operand> createOperands(String[] numbers) {
        List<Operand> results = new ArrayList<>();
        for (String number : numbers) {
            results.add(new Operand(number));
        }
        return results;
    }

    public int size() {
        return operands.size();
    }

    public int sum() {
        int total = 0;

        for (Operand operand : operands) {
            total += operand.getNumber();
        }

        return total;
    }

    public List<Operand> getOperands() {
        return operands;
    }
}
