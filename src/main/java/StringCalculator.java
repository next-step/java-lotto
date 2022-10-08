import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public static int calculator(String s) {
        List<String> values = new ArrayList<>(Arrays.asList(splitString(s)));

        if (values.contains("+")) {
            return Integer.parseInt(values.get(0)) + Integer.parseInt(values.get(2));
        }

        if (values.contains("-")) {
            return Integer.parseInt(values.get(0)) - Integer.parseInt(values.get(2));
        }

        if (values.contains("*")) {
            return Integer.parseInt(values.get(0)) * Integer.parseInt(values.get(2));
        }

        if (values.contains("/")) {
            return Integer.parseInt(values.get(0)) / Integer.parseInt(values.get(2));
        }

        return 0;
    }

    public static String[] splitString(String s) {
        return s.split(" ");
    }
}
