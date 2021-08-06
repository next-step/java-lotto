package step1;

public class StringAddCalculator {

    private static final int ZERO = 0;

    public static int splitAndSum(String textValue) {

        Converter converter = new Converter();

        if ("".equals(textValue) || textValue == null) {
            return 0;
        }

        int result = ZERO;

        for (String number : converter.parseNumber(textValue)) {
            result += inNegative(Integer.parseInt(number));
        }

        return result;
    }


    private static int inNegative(int num) {
        if (num < 0) {
            throw new RuntimeException();
        }
        return num;
    }

}



