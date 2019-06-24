public class StringCalculator {

    public static int calculator(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = Separator(input);
        int sum = 0;
        for (String number : numbers) {
            sum += numberValidator(number);
        }
        return sum;
    }

    public static String[] Separator(String input){
        return input.split(",|:");
    }

    public static int numberValidator(String number) {
        if (isNumber(number) && isNegative(number)) {
            throw new RuntimeException();
        }
        return Integer.parseInt(number);
    }

    public static boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNegative(String number) {
        return Integer.parseInt(number) < 0 ? true : false;
    }
}
