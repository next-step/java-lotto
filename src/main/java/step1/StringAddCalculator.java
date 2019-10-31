package step1;

import java.util.Objects;

public class StringAddCalculator {
    public int add(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            return 0;
        }

        String delimiter = "[,:]";
        if (input.contains("\n")) {
            delimiter = input.substring(2, 3);
            input = input.substring(4);
        }

        int sum = 0;
        final String[] split = input.split(delimiter);
        for (final String s : split) {
            final int i = Integer.parseInt(s);
            if (i < 0){
                throw new IllegalArgumentException();
            }
            sum += i;
        }

        return sum;
    }
}
