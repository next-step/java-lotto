package calculator;

public class StringCalculator {


    public int splitAndCalculate(String source) {
        String[] splits = source.split(" ");
        int result = Integer.parseInt(splits[0]);

        for (int i = 1; i < splits.length; i++) {
            if (splits[i].equals("+")) {
                result += Integer.parseInt(splits[i + 1]);
            } else if (splits[i].equals("-")) {
                result -= Integer.parseInt(splits[i + 1]);
            }
        }

        return result;
    }
}
