package step1.domain;

public class StringCalculator {

    public int calculate(Numbers numbers, Operations operations) {
        int result = 0;
        while (operations.hasNext()) {
            Operator operator = operations.next();
            Integer left = numbers.getNextNumber();
            Integer right = numbers.getNextNumber();
            result = operator.calculate(left, right);

            numbers.add(result);
        }
        return result;
    }
}

