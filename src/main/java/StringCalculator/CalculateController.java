package StringCalculator;

import java.util.ArrayList;
import java.util.List;

public class CalculateController {
    public void run() {
        String[] calcaultionValues = InputView.inputCalculation();

        List<Integer> numbers = new ArrayList<>();
        List<Operator> operators = new ArrayList<>();

        for (int index = 0; index < calcaultionValues.length; index++) {
            if (isNumberPosition(index)) {
                numbers.add(Integer.parseInt(calcaultionValues[index]));
            }
            if (!isNumberPosition(index)) {
                operators.add(Operator.from(calcaultionValues[index]));
            }
        }

        int sum = numbers.get(0);
        for (int index = 0; index < operators.size(); index++) {
            Operator operator = operators.get(index);
            int number = numbers.get(index + 1);

            sum = operator.calculateBy(sum, number);
        }

        System.out.println(sum);
    }

    private boolean isNumberPosition(int index) {
        return index % 2 == 0;
    }
}
