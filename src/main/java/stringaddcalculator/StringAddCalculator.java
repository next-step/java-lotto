package stringaddcalculator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (input == null) return 0;
        if (input.isEmpty()) return 0;

        if (1 == input.length())
            return Integer.parseInt(input);



            return -1;
    }
}
