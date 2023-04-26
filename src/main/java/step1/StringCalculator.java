package step1;


public class StringCalculator {
    private static final String DELIMITER = " ";

    public static Integer calculate(String input) {
        validateNullOrBlank(input);
        String[] numbersAndSigns = splitInput(input);
        return operate(toNumbers(numbersAndSigns), toOperations(numbersAndSigns));
    }

    private static void validateNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값은 null 이거나 공백일 수 없습니다.");
        }
    }

    private static String[] splitInput(String input) {
        return input.split(DELIMITER);
    }

    private static Numbers toNumbers(String[] numbersAndSigns) {
        Numbers numbers = new Numbers();
        for (int i = 0; i < numbersAndSigns.length; i = i + 2) {
            numbers.add(Numbers.toNumber(numbersAndSigns[i]));
        }
        return numbers;
    }

    private static Operations toOperations(String[] numbersAndSigns) {
        Operations operations = new Operations();
        for (int i = 1; i < numbersAndSigns.length; i = i + 2) {
            operations.add(Operation.toOperation(numbersAndSigns[i]));
        }
        return operations;
    }

    private static int operate(Numbers numbers, Operations operations) {
        int answer = 0;
        while (!operations.isEmpty()) {
            answer = operations.pop().operate(answer, numbers.pop());
        }
        return answer;
    }
}
