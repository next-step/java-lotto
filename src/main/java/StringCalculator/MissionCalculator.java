package StringCalculator;

import java.util.ArrayList;
import java.util.List;

public class MissionCalculator {
    private List<Integer> calculationArgument;

    public MissionCalculator(String[] value) {
        this.calculationArgument = new ArrayList<>();
        for (String input : value) {
            calculationArgument.add(Integer.valueOf(input));
        }
    }

    public int calculate() {
        return calculationArgument
                .stream()
                .reduce(Integer::sum)
                .get();
    }
}
