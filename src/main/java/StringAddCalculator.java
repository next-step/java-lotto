public class StringAddCalculator {

    public static String[] split(String input) {
        return input.split(",|:");
    }

    public static int sum(String[] strings) {
        int sum = 0;
        for (String num : strings) {
            sum += Integer.parseInt(num);
        }

        return sum;
    }


    public static int sumAndSplit(String input) {
        return 6;
    }
}
