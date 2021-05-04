package domain.calculator;

import java.util.Arrays;

public class Calculator {

    public String escape(String numbers) {
        String custom = "";
        if (numbers.contains("//") && numbers.contains("\n")) {
            custom = numbers.substring(2, 3);
            return custom;
        }
        return custom;
    }

    public boolean isNullAndSpace(String numbers) {
        if (numbers.length() == 0 || numbers == null) {
            return true;
        }
        return false;
    }

    public int add(String numbers) {
        if (isNullAndSpace(numbers)) {
            return 0;
        }
        String custom = escape(numbers);

        int sum = Arrays.stream(numbers.split("[,|:|//" + custom + "\\n]+"))
                .filter((c) -> {
                    if (c.matches("[^0-9][-0-9]+")) {
                        throw new RuntimeException();
                    }
                    return !c.equals("");
                }).mapToInt(Integer::parseInt).sum();
        return sum;
    }
}
