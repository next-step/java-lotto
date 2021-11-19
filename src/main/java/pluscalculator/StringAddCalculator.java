package pluscalculator;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        FomularInterface instance = FomularFactory.getInstance(input);
        return instance.calc(input);
    }

}
