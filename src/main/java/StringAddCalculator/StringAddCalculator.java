package StringAddCalculator;

public class StringAddCalculator {
    public static int splitAndSum(Object o) {

        String word = (String) o;

        int result = 0;

        Adder adder = new Adder();

        if (word == null || word.isEmpty()) {
        } else if (word.length() == 1)  {
            result = Integer.parseInt(word);
        } else if (!word.contains("//") && !word.contains("\n")) {
            String[] arr = word.split(",|:");
            result = adder.addCalculator(arr);
        } else if (word.contains("//") && word.contains("\n")) {
            String separator = word.substring(2,3);
            word = word.substring(word.indexOf("\n") + 1);
            String[] arr = word.split(separator);
            result = adder.addCalculator(arr);
        }

        return result;
    }

}
