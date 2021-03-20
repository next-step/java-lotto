package splitandsum;

public class StringAddCalculator {

    public static int splitAndSum(String str) {
        Numbers numbers = new Numbers(str);
        int result = numbers.getNumbers().stream()
                .mapToInt(Number::getNumber)
                .reduce(Integer::sum)
                .getAsInt();
        return result;
    }
}
