package calculator;

public class StringAddCalculator {

    //text와 delimiter를 구하고 더한다.
    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        InputCheckor inputCheckor = new InputCheckor(input);
        inputCheckor.findDelimiterAndText(input);
        String text = inputCheckor.getText();
        String delimiter = inputCheckor.getDelimiter();

        String[] numbers = text.split(delimiter);
        return sumNumberString(numbers);
    }

    //더하기
    public static int sumNumberString(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

}

