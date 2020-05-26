package stringaddcalculator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (input == null) return 0;
        if (input.isEmpty()) return 0;

        if (input.length() == 1)
            return Integer.parseInt(input);

        String[] splitData = input.split(",");
        int result = 0;
        for(String data:splitData)
            result += Integer.parseInt(data);

        return result;
    }
}
