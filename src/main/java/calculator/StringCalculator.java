package calculator;

public class StringCalculator {

    public int splitAndCalculate(String source) {
        String[] splits = source.split(" ");
        int result = new PositiveInteger(splits[0]).getPositiveNumber();

        for (int i = 1; i < splits.length; i++) {
            if (splits[i].equals("+")) {
                result += new PositiveInteger(splits[i + 1]).getPositiveNumber();
            } else if (splits[i].equals("-")) {
                result -= new PositiveInteger(splits[i + 1]).getPositiveNumber();
            } else if (splits[i].equals("*")) {
                result *= new PositiveInteger(splits[i + 1]).getPositiveNumber();
            } else if (splits[i].equals("/")) {
                result /= new PositiveInteger(splits[i + 1]).getPositiveNumber();
            }
        }

        return result;
    }
}
