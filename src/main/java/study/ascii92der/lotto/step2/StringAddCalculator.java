package study.ascii92der.lotto.step2;

public class StringAddCalculator {

    public static int splitAndSum(String stringValues) {
        if (stringValues == null || stringValues.isEmpty()) {
            return 0;
        }
        return -1;
    }

    public static String[] split(String stringValues) {

        return stringValues.split("[,:]");
    }

    public static int sum(String[] values) {
        int result = 0;
        for(String value:values) result += Integer.parseInt(value);
        return result;
    }
}
