public class StringCalculator {
    public static int calculate(String text) {
        if (text == null || text.isEmpty())
            return 0;

        String[] valules = text.split(",|:");

        if (valules.length == 1)
            return Integer.parseInt(valules[0]);

        return 0;
    }
}
