package calculator;

import java.util.List;

public class StringCalculator {

    private static final String BLANK = " ";
    private static final int CALCULATION_FIRST_NUMBER_INDEX = 0;
    private static final int CALCULATION_START_INDEX = 1;
    private static final int CALCULATION_NEXT_RANGE = 2;

    private List<CalculateStrategy> calculateStrategys;

    public StringCalculator(final List<CalculateStrategy> calculateStrategys) {
        this.calculateStrategys = calculateStrategys;
    }

    public int calculation(final String input) {
        String[] split = input.split(BLANK);
        Number number = new Number(split[CALCULATION_FIRST_NUMBER_INDEX]);
        for (int i = CALCULATION_START_INDEX; i < split.length; i += CALCULATION_NEXT_RANGE) {
            calculate(number, split[i], split[i+1]);
        }
        return number.getIntValue();
    }

    private void calculate(final Number number, final String separator, final String target) {
        calculateStrategys.stream()
                .filter(calculateStrategy -> calculateStrategy.support(separator))
                .findFirst()
                .ifPresent(calculateStrategy -> calculateStrategy.calculate(number, target));
    }




}
