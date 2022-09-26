package step1;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public static int add(String text) {
        String[] addParameters = text.split(" ");

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < addParameters.length; i++) {
            isNumeric(addParameters[i], numbers);
        }

        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    public static int minus(String text) {
        String[] minusParameters = text.split(" ");

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < minusParameters.length; i++) {
            isNumeric(minusParameters[i], numbers);
        }

        return numbers.stream()
                .reduce((a, b) -> a - b)
                .get().intValue();
    }

    private static boolean isNumeric(String addParameter, List<Integer> numbers){
        try {
            int number = Integer.parseInt(addParameter);
            numbers.add(number);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }
}
