package calculator.domain;

public class Calculator {
    public long calculate(String input) {
        if(input == null || input.isBlank()) {
            throw new IllegalArgumentException("input should not be blank");
        }

        String[] elements = input.split(" ");
        if(elements.length % 2 == 0) {
            throw new IllegalArgumentException("input is invalid format");
        }

        long result = parseNumber(elements[0]);

        for(int i=1; i<elements.length; i=i+2) {
            String operator = elements[i];
            long number = parseNumber(elements[i+1]);
            result = calculateOnce(operator, result, number);
        }

        return result;
    }

    private long parseNumber(String element) {
        try {
            return Long.parseLong(element);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("element '%s' is not number", element));
        }
    }

    private long calculateOnce(String operator, long result, long number) {
        if (operator.equals("+")) {
            return add(result, number);
        } else if (operator.equals("-")) {
            return subtract(result, number);
        } else if (operator.equals("*")) {
            return multiple(result, number);
        } else if (operator.equals("/")) {
            return divide(result, number);
        }
        throw new IllegalArgumentException("operator is not allowed except +,-,*,/");
    }

    private long add(long result, long number) {
        return result + number;
    }
    private long subtract(long result, long number) {
        return result - number;
    }
    private long multiple(long result, long number) {
        return result * number;
    }
    private long divide(long result, long number) {
        long value = result / number;
        if (value * number != result)
            throw new IllegalArgumentException("result of division should be integer");
        return value;
    }

}
