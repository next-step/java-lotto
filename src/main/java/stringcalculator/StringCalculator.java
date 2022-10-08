package stringcalculator;

public class StringCalculator {
    public static Number add(Number result, int back) {
        result.add(back);
        return result;
    }

    public static Number minus(Number result, int back) {
        result.minus(back);
        return result;
    }

    public static Number multiply(Number result, int back) {
        result.multiply(back);
        return result;
    }

    public static Number division(Number result, int back) {
        result.division(back);
        return result;
    }
}
