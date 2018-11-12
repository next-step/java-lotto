package calculator;

public class StringCalculator {
    private int sum;
    private String regex;

    public static int add(String text) {

        int sum = 0;
        String regex = ",|:";

        if(text.isEmpty()   ){
            return sum;
        }

        String[] values = text.split(ifCustomRegex(text, regex));
        for (String value : values) {
            sum += Integer.parseInt(value);
        }

        return sum;
    }

    public static String ifCustomRegex(String text, String regex) {
        if (text.startsWith("//")) {
            regex += "|" + text.substring(2, text.indexOf("\\n"));
        }
        return regex;
    }

}
