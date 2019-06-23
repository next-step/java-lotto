import org.assertj.core.util.Strings;

public class StringCalculator {

    public int add(String input) throws Exception {
        if (Strings.isNullOrEmpty(input)) {
            return 0;
        }

        if (input.length() == 1) {
            return Integer.parseInt(input);
        }

        return splitAndSum(input);
    }

    public int splitAndSum(String input) {
        String[] result = input.split(",|:");
        int sum = 0;

        for (int i = 0; i < result.length; ++i) {
            sum+= Integer.parseInt(result[i]);
        }
        return sum;
    }

}
