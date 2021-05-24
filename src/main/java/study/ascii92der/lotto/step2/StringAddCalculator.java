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
}
