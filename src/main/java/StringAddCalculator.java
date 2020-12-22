public class StringAddCalculator {
    public int splitAndSum(String input) {
        int sum = 0;
        if (input == null) {
            return sum = 0;
        }
        if (input.isEmpty()) {
            return sum = 0;
        }
        if (input.length() == 1) {
            return sum = Integer.parseInt(input);
        }
        return 0;
    }
}
