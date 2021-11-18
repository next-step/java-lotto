package pluscalculator;

public class NormalFomular extends Fomular {
    private static final String REGEX = "[,:]";

    @Override
    public int calc(String input) {
        int result = 0;
        String[] tokens = input.split(REGEX);
        for (String s : tokens) {
            int number = Integer.parseInt(s);
            validateMinusNum(s);
            result += number;
        }
        return result;
    }
}
