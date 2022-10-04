package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class CalculationResult {

    private int sequence = 0;
    private final List<Long> result = new ArrayList<>();

    private CalculationResult() {}

    public static CalculationResult init() {

        return new CalculationResult();
    }

    public void calculate(final Expressions expressions) {

        final List<Number> numbers = expressions.disunite();
        final List<Operation> operations = expressions.separate();
        for (Operation operation : operations) {
            separate(operation, numbers);
        }
    }

    private void separate(final Operation operation, final List<Number> numbers) {

        if (sequence == 0) {
            final Number currentNumber = numbers.get(sequence);
            final Number afterNumber = numbers.get(sequence + 1);
            save(operate(operation, currentNumber, afterNumber));
            return ;
        }
        if (sequence != 0) {
            final Number beforeNumber = new Number(result.get(sequence -1));
            final Number afterNumber = numbers.get(sequence + 1);
            save(operate(operation, beforeNumber, afterNumber));
            return ;
        }
    }

    private long operate(final Operation operation, final Number number1, final Number number2) {

        return Operation.from(operation.getOperation())
                .calculate(number1.getNumber(), number2.getNumber());
    }

    public void save(final long value) {

        result.add(sequence, value);
        this.sequence++;
    }

    public long findLast() {

        return result.get(sequence - 1);
    }
}
